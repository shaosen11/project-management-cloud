package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectUserDuty;
import com.edu.lingnan.service.ProjectUserDutyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectUserDuty)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:17:59
 */
@RestController
@RequestMapping("projectUserDuty")
public class ProjectUserDutyController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectUserDutyService projectUserDutyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectUserDuty selectOne(Integer id) {
        return this.projectUserDutyService.queryById(id);
    }

}