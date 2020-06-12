package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectUser;
import com.edu.lingnan.service.ProjectUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectUser)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:17:45
 */
@RestController
@RequestMapping("projectUser")
public class ProjectUserController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectUserService projectUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectUser selectOne(Integer id) {
        return this.projectUserService.queryById(id);
    }

}