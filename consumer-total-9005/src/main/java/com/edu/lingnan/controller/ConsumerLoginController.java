package com.edu.lingnan.controller;

import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.feign.ProjectFeignService;
import com.edu.lingnan.feign.SysUserFeignService;
import com.edu.lingnan.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 20:25 2020/6/17
 */
@Controller
public class ConsumerLoginController {
    @Autowired
    private ProjectFeignService projectFeignService;

    @Autowired
    private SysUserFeignService sysUserFeignService;

    @GetMapping(value = {"/index", "/"})
    public String index(HttpServletRequest request) {
        //获取myUserDetails对象
        MyUserDetails myUserDetails = UserUtil.getMyUserDetailsBySecurity(request);
        Integer userId = null;
        String username = null;
        String email = null;
        String photo = null;
        if (myUserDetails != null) {
            userId = myUserDetails.getId();
            username = myUserDetails.getUsername();
            email = myUserDetails.getEmail();
            photo = myUserDetails.getPhoto();
        }
        HttpSession session = request.getSession();
        session.setAttribute("userId", userId);
        session.setAttribute("username", username);
        session.setAttribute("email", email);
        session.setAttribute("photo", photo);
        //统计用户，项目数量
        Integer userCount = sysUserFeignService.getUserCount();
        session.setAttribute("userCount", userCount);
        Integer projectCount = projectFeignService.getProjectCount();
        session.setAttribute("projectCount", projectCount);
        return "index";
    }

}
