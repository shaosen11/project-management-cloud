package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectCodeLine;
import com.edu.lingnan.feign.ProjectCodeLineFeignService;
import com.edu.lingnan.service.ProjectCodeLineService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectCodeLine)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:16:33
 */
@RestController
@RequestMapping("projectCodeLine")
public class ProjectCodeLineController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectCodeLineService projectCodeLineService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectCodeLine selectOne(Integer id) {
        return this.projectCodeLineService.queryById(id);
    }

}