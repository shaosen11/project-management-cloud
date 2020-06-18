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
     * 增
     * @param sysUser
     * @return
     */
    @PostMapping("/")
    public boolean addSysUser(SysUser sysUser){
        return sysUserService.insert(sysUser);
    }

    /**
     * 查
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public SysUser getSysUser(@PathVariable("id") Integer id) {
        return this.sysUserService.queryById(id);
    }

    /**
     * 改
     * @param sysUser
     * @return
     */
    @PutMapping("/")
    public boolean updateSysUser(SysUser sysUser){
        return sysUserService.update(sysUser);
    }

    @GetMapping("/getUserCount")
    public Integer userCount(){
        return sysUserService.userCount();
    }
}