package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectFunction;
import com.edu.lingnan.service.ProjectFunctionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectFunction)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:16:42
 */
@RestController
@RequestMapping("projectFunction")
public class ProjectFunctionController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectFunctionService projectFunctionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectFunction selectOne(Integer id) {
        return this.projectFunctionService.queryById(id);
    }

}