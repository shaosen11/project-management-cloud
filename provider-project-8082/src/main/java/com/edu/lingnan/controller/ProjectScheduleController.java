package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectSchedule;
import com.edu.lingnan.feign.ProjectScheduleFeignService;
import com.edu.lingnan.service.ProjectScheduleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectSchedule)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:17:29
 */
@RestController
@RequestMapping("projectSchedule")
public class ProjectScheduleController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectScheduleService projectScheduleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectSchedule selectOne(Integer id) {
        return this.projectScheduleService.queryById(id);
    }

}