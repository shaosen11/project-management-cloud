package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectUserCooperation;
import com.edu.lingnan.service.ProjectUserCooperationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectUserCooperation)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:17:51
 */
@RestController
@RequestMapping("projectUserCooperation")
public class ProjectUserCooperationController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectUserCooperationService projectUserCooperationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectUserCooperation selectOne(Integer id) {
        return this.projectUserCooperationService.queryById(id);
    }

}