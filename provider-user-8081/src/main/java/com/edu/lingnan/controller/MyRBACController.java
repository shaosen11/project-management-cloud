package com.edu.lingnan.controller;

import com.edu.lingnan.service.MyRBACService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 0:00 2020/6/18
 */
@RestController
@RequestMapping("MyRBAC")
public class MyRBACController {
    @Autowired
    private MyRBACService myRBACService;

    @GetMapping("findUrlsByEmail")
    public List<String> findUrlsByEmail(String email) {
        return myRBACService.findUrlsByEmail(email);
    }
}
