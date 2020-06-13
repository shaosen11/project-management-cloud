package com.edu.lingnan.controller;

import com.edu.lingnan.feign.SysUserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:48:12
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Autowired
    private SysUserFeignService sysUserFeignService;


}