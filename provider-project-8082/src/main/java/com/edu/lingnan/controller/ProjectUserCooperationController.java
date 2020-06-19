package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectUserCooperation;
import com.edu.lingnan.feign.ProjectUserCooperationFeignService;
import com.edu.lingnan.service.ProjectUserCooperationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("/getByProjectIdAndInProjectUserIdAndNotInProjectUserIdAndInviteAndFinish/{projectId}/{inProjectUserId}/{notInProjectUserId}/{inviteFlag}/{finishFlag}")
    ProjectUserCooperation getByProjectIdAndInProjectUserIdAndNotInProjectUserIdAndInviteAndFinish(Integer projectId, Integer inProjectUserId, Integer notInProjectUserId, Integer inviteFlag, Integer finishFlag) {
        return projectUserCooperationService.getByProjectIdAndInProjectUserIdAndNotInProjectUserIdAndInviteAndFinish(projectId, inProjectUserId, notInProjectUserId, inviteFlag, finishFlag);
    }

    @PostMapping("/")
    boolean insert(ProjectUserCooperation projectsUserCooperation){
        return projectUserCooperationService.insert(projectsUserCooperation);
    }

    @PutMapping("/")
    boolean update(ProjectUserCooperation projectsUserCooperation){
        return projectUserCooperationService.update(projectsUserCooperation);
    }

    @GetMapping("/{id}")
    ProjectUserCooperation getById(@PathVariable("id") Integer id){
        return projectUserCooperationService.getById(id);
    }

    @GetMapping("/getByProjectIdAndNotInProjectUserIdAndInviteAndFinish/{projectId}/{notInProjectUserId}/{inviteFlag}/{finishFlag}")
    List<ProjectUserCooperation> getByProjectIdAndNotInProjectUserIdAndInviteAndFinish(Integer projectId, Integer notInProjectUserId, Integer inviteFlag, Integer finishFlag){
        return projectUserCooperationService.getByProjectIdAndNotInProjectUserIdAndInviteAndFinish(projectId, notInProjectUserId, inviteFlag, finishFlag);
    }
}