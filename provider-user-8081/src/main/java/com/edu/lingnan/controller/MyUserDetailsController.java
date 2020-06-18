package com.edu.lingnan.controller;

import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.service.MyUserDetailsService;
import com.edu.lingnan.service.impl.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author shaosen
 * @Description //TODO
 * @Date 21:06 2020/6/17
 */
@RestController
@RequestMapping("MyUserDetails")
public class MyUserDetailsController {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/findByEmail")
    public MyUserDetails findByEmail(String email) {
        return myUserDetailsService.findByEmail(email);
    }

    @PostMapping("/findRoleByEmail")
    public List<String> findRoleByEmail(String email) {
        return myUserDetailsService.findRoleByEmail(email);
    }

    @PostMapping("/findAuthorityByEmail")
    public List<String> findAuthorityByEmail(String email) {
        return myUserDetailsService.findAuthorityByEmail(email);
    }


    @PostMapping("/loadUserByUsername")
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return myUserDetailsService.loadUserByUsername(email);
    }
}
