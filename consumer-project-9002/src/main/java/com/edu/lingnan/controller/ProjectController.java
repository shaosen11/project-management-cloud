package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Project;
import com.edu.lingnan.feign.ProjectFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Project)表控制层
 *
 * @author makejava
 * @since 2020-06-11 23:21:30
 */
@RestController
@RequestMapping("project")
public class ProjectController {
    /**
     * 服务对象
     */
    @Autowired
    private ProjectFeignService projectFeignService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    public Project selectOne(@PathVariable("id") Integer id) {
        return this.projectFeignService.queryById(id);
    }

}