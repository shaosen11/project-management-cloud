package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectMessageNeedToDoRelationship;
import com.edu.lingnan.feign.ProjectMessageNeedToDoRelationshipFeignService;
import com.edu.lingnan.service.ProjectMessageNeedToDoRelationshipService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectMessageNeedToDoRelationship)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:16:59
 */
@RestController
@RequestMapping("projectMessageNeedToDoRelationship")
public class ProjectMessageNeedToDoRelationshipController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectMessageNeedToDoRelationshipService projectMessageNeedToDoRelationshipService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectMessageNeedToDoRelationship selectOne(Integer id) {
        return this.projectMessageNeedToDoRelationshipService.queryById(id);
    }

}