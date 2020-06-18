package com.edu.lingnan.security;

import com.edu.lingnan.exception.AJaxResponse;
import com.edu.lingnan.utils.AfterLoginOrLoginOutHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shaosen
 */
@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private String loginType = "json";

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    AfterLoginOrLoginOutHandler afterLoginOrLoginOutHandler;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        if(loginType.equalsIgnoreCase("JSON")){
            afterLoginOrLoginOutHandler.afterLoginOrLoginOutHandler(request, "登录系统");
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(AJaxResponse.success("/index","登录成功！")));
        }else {
            //跳转登录之前请求的页面
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }

}
