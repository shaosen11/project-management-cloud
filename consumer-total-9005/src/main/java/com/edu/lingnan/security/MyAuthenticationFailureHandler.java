package com.edu.lingnan.security;

import com.edu.lingnan.exception.AJaxResponse;
import com.edu.lingnan.exception.CustomException;
import com.edu.lingnan.exception.CustomExceptionType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shaosen
 */
@Component
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private String loginType = "json";

    private static ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException, ServletException {
        String errorMsg = "用户名或者密码输入错误";
        if (exception instanceof SessionAuthenticationException) {
            errorMsg = exception.getMessage();
        }
        if(loginType.equalsIgnoreCase("JSON")){
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(
                    AJaxResponse.error(new CustomException(
                            CustomExceptionType.USER_INPUT_ERROR, errorMsg
                    ))
            ));

        }else {
            //跳转登录之前请求的页面
            response.setContentType("text/html;charset=UTF-8");
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
