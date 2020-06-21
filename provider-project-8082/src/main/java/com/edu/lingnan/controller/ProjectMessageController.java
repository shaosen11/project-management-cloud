package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectMessage;
import com.edu.lingnan.feign.ProjectMessageFeignService;
import com.edu.lingnan.service.ProjectMessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("getByProjectIdAndUserId/{projectId}/{userId}/{offset}/{pageSize}")
    List<ProjectMessage> getByProjectIdAndUserId(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("userId") Integer userId,
            @PathVariable("offset") Integer offset,
            @PathVariable("pageSize") Integer pageSize){
        return projectMessageService.getByProjectIdAndUserId(projectId, userId, offset, pageSize);
    }

    @PostMapping("/")
    boolean insert(ProjectMessage projectsMessage){
        return projectMessageService.insert(projectsMessage);
    }

    @GetMapping("getByProjectId/{projectId}/{offset}/{pageSize}")
    List<ProjectMessage> getByProjectId(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("offset") Integer offset,
            @PathVariable("pageSize") Integer pageSize){
        return projectMessageService.getByProjectId(projectId, offset, pageSize);
    }

    @PutMapping("/")
    boolean update(ProjectMessage projectsMessage){
        return projectMessageService.update(projectsMessage);
    }

    @PutMapping("updateProjectMessageIsReadByProjectMessageId/{projectMessageId}")
    boolean updateProjectMessageIsReadByProjectMessageId(@PathVariable("projectMessageId") Integer projectMessageId){
        return projectMessageService.updateProjectMessageIsReadByProjectMessageId(projectMessageId);
    }

    @GetMapping("getAllNeedToByProjectId/{projectId}/{offset}/{pageSize}")
    List<ProjectMessage> getAllNeedToByProjectId(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("offset") Integer offset,
            @PathVariable("pageSize") Integer pageSize){
        return projectMessageService.getAllNeedToByProjectId(projectId, offset, pageSize);
    }

    @GetMapping("/{id}")
    ProjectMessage getById(@PathVariable("id") Integer id){
        return projectMessageService.getById(id);
    }

    @GetMapping("getProjectMessageCount/{projectId}/{userId}")
    Integer getProjectMessageCount(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("userId") Integer userId){
        return projectMessageService.getProjectMessageCount(projectId, userId);
    }

    @GetMapping("getProjectMessageNeedToDoCount/{projectId}")
    Integer getProjectMessageNeedToDoCount(@PathVariable("projectId") Integer projectId){
        return projectMessageService.getProjectMessageNeedToDoCount(projectId);
    }

}