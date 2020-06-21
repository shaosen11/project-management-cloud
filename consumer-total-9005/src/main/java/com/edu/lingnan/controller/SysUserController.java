package com.edu.lingnan.controller;

import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.fegin.MyUserDetailsFeignService;
import com.edu.lingnan.feign.SysUserFeignService;
import com.edu.lingnan.service.MyUserDetailsService;
import com.edu.lingnan.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 11:04 2020/6/20
 */
@Controller
public class SysUserController {
    @Autowired
    private MyUserDetailsFeignService myUserDetailsFeignService;

    @Autowired
    private SysUserFeignService sysUserFeignService;

    @GetMapping("/projectManagementAdmin")
    @ResponseBody
    public String projectManagementAdmin(HttpServletRequest request){
        MyUserDetails myUserDetails = UserUtil.getMyUserDetailsBySecurity(request);
        List<String> role = myUserDetailsFeignService.findRoleByEmail(myUserDetails.getEmail());
        for (String s : role) {
            if (s.equals("admin")){
                return s;
            }
        }
        return null;
    }

    @ResponseBody
    @GetMapping("/user_information")
    public MyUserDetails userInformetion(Integer userId){
        return sysUserFeignService.getMyUserDetailsByUserId(userId);
    }
}
