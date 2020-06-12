package com.edu.lingnan.controller;

import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.service.SysUserService;
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
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public SysUser selectOne(@PathVariable("id") Integer id) {
        return this.sysUserService.queryById(id);
    }

}