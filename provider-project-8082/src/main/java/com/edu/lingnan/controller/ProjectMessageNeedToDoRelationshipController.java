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

    @GetMapping("getByProjectMessageId/{projectMessageId}")
    public ProjectMessageNeedToDoRelationship getByProjectMessageId(@PathVariable("projectMessageId") Integer projectMessageId) {
        return projectMessageNeedToDoRelationshipService.getByProjectMessageId(projectMessageId);
    }

    @GetMapping("getByDocumentId/{documentId}")
    public ProjectMessageNeedToDoRelationship getByDocumentId(@PathVariable("documentId") Integer documentId) {
        return projectMessageNeedToDoRelationshipService.getByDocumentId(documentId);
    }

    @PostMapping("/")
    public void insert(ProjectMessageNeedToDoRelationship projectsMessageNeedToDoRelationship) {
        projectMessageNeedToDoRelationshipService.insert(projectsMessageNeedToDoRelationship);
    }

}