package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectType;
import com.edu.lingnan.service.ProjectTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectType)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:17:37
 */
@RestController
@RequestMapping("projectType")
public class ProjectTypeController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectTypeService projectTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectType selectOne(Integer id) {
        return this.projectTypeService.queryById(id);
    }

}