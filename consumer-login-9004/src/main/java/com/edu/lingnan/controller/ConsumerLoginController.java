package com.edu.lingnan.controller;

import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.feign.LoginFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * (Document)表控制层
 *
 * @author makejava
 * @since 2020-06-11 23:49:00
 */
@Controller
@RequestMapping("sysUser")
public class ConsumerLoginController {
    /**
     * 服务对象
     */
    @Autowired
    private LoginFeignService loginFeignService;

    @GetMapping("/tologin")
    public String tologin(){
        return "login1";
    }

    @PostMapping("/login")
    public String login(String email, String password, HttpServletResponse response){
        String token = UUID.randomUUID().toString() + "shaosen";
        Cookie cookie = new Cookie("TOKEN", token);
        cookie.setDomain("projectmanagement.com");
        response.addCookie(cookie);
        SysUser sysUser = loginFeignService.login(email, password, token);
        if (sysUser!=null){
            return "index";
        }
        return "login";
    }

    @RequestMapping("/user")
    @ResponseBody
    public ResponseEntity<SysUser> getUserInfo(@CookieValue(required = false, value = "token")String token) {
        System.out.println(token+"22222");
        if (!StringUtils.isEmpty(token)) {
            SysUser sysUser = loginFeignService.getUserInfo(token);
            System.out.println(sysUser+"1111111");
            return ResponseEntity.ok(sysUser);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<SysUser> getUserInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(loginFeignService.getUserById(id));
    }
}