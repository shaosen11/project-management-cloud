package com.edu.lingnan.feign;

import com.edu.lingnan.entity.ProjectUserCooperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * (ProjectUserCooperation)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:14:14
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface ProjectUserCooperationFeignService {

    @GetMapping("/getByProjectIdAndInProjectUserIdAndNotInProjectUserIdAndInviteAndFinish/{projectId}/{inProjectUserId}/{notInProjectUserId}/{inviteFlag}/{finishFlag}")
    ProjectUserCooperation getByProjectIdAndInProjectUserIdAndNotInProjectUserIdAndInviteAndFinish(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("inProjectUserId") Integer inProjectUserId,
            @RequestParam("notInProjectUserId") Integer notInProjectUserId,
            @RequestParam("inviteFlag") Integer inviteFlag,
            @RequestParam("finishFlag") Integer finishFlag);

    @PostMapping("/")
    boolean insert(ProjectUserCooperation projectsUserCooperation);

    @PutMapping("/")
    boolean update(ProjectUserCooperation projectsUserCooperation);

    @GetMapping("/{id}")
    ProjectUserCooperation getById(@RequestParam("id") Integer id);

    @GetMapping("/getByProjectIdAndNotInProjectUserIdAndInviteAndFinish/{projectId}/{notInProjectUserId}/{inviteFlag}/{finishFlag}")
    List<ProjectUserCooperation> getByProjectIdAndNotInProjectUserIdAndInviteAndFinish(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("notInProjectUserId") Integer notInProjectUserId,
            @RequestParam("inviteFlag") Integer inviteFlag,
            @RequestParam("finishFlag") Integer finishFlag);
}