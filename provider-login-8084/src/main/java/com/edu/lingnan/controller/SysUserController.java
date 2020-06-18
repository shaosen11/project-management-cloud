package com.edu.lingnan.controller;

import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.service.SysUserService;
import com.edu.lingnan.utils.LoginCacheUtil;
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
 * @Author shaosen
 * @Description //TODO
 * @Date 10:40 2020/6/16
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;


}
