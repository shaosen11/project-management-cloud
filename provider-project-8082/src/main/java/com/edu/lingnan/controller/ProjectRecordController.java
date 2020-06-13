package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectRecord;
import com.edu.lingnan.feign.ProjectRecordFeignService;
import com.edu.lingnan.service.ProjectRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectRecord)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:17:22
 */
@RestController
@RequestMapping("projectRecord")
public class ProjectRecordController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectRecordService projectRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectRecord selectOne(Integer id) {
        return this.projectRecordService.queryById(id);
    }

}