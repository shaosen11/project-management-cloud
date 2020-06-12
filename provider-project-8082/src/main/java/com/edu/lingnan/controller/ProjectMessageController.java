package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectMessage;
import com.edu.lingnan.service.ProjectMessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectMessage)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:16:50
 */
@RestController
@RequestMapping("projectMessage")
public class ProjectMessageController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectMessageService projectMessageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectMessage selectOne(Integer id) {
        return this.projectMessageService.queryById(id);
    }

}