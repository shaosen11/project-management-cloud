package com.edu.lingnan.feign;

import com.edu.lingnan.entity.Document;
import com.edu.lingnan.entity.SysUser;
import com.sun.deploy.net.HttpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 15:06 2020/6/16
 */
@Component
@FeignClient(value = "PRODIVER-LOGIN")
public interface LoginFeignService {

    @PostMapping("sysUser/login")
    SysUser login(@RequestParam("email")String email,
                  @RequestParam("password") String password,
                  @RequestParam("token") String token
    );

    @GetMapping("sysUser/user")
    SysUser getUserInfo(String token);

    @GetMapping("sysUser/user/{id}")
    SysUser getUserById(@PathVariable("id") Integer id);
}
