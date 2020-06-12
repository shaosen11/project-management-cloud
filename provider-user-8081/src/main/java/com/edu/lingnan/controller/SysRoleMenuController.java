package com.edu.lingnan.controller;

import com.edu.lingnan.entity.SysRoleMenu;
import com.edu.lingnan.service.SysRoleMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysRoleMenu)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:13:20
 */
@RestController
@RequestMapping("sysRoleMenu")
public class SysRoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysRoleMenu selectOne(Integer id) {
        return this.sysRoleMenuService.queryById(id);
    }

}