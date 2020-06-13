package com.edu.lingnan.controller;

import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.feign.SysUserFeignService;
import com.edu.lingnan.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2020-06-11 20:52:18
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
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