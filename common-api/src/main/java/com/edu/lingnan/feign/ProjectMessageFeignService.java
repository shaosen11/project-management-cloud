package com.edu.lingnan.feign;

import com.edu.lingnan.entity.ProjectMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * (ProjectMessage)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:13:29
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface ProjectMessageFeignService {

    @GetMapping("projectMessage/getByProjectIdAndUserId/{projectId}/{userId}/{offset}/{pageSize}")
    List<ProjectMessage> getByProjectIdAndUserId(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("userId") Integer userId,
            @RequestParam("offset") Integer offset,
            @RequestParam("pageSize") Integer pageSize);

    @PostMapping("projectMessage/")
    boolean insert(ProjectMessage projectsMessage);

    @GetMapping("projectMessage/getByProjectId/{projectId}/{offset}/{pageSize}")
    List<ProjectMessage> getByProjectId(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("offset") Integer offset,
            @RequestParam("pageSize") Integer pageSize);

    @PutMapping("projectMessage/")
    boolean update(ProjectMessage projectsMessage);

    @PutMapping("projectMessage/updateProjectMessageIsReadByProjectMessageId/{projectMessageId}")
    boolean updateProjectMessageIsReadByProjectMessageId(@RequestParam("projectMessageId") Integer projectMessageId);

    @GetMapping("projectMessage/getAllNeedToByProjectId/{projectId}/{offset}/{pageSize}")
    List<ProjectMessage> getAllNeedToByProjectId(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("offset") Integer offset,
            @RequestParam("pageSize") Integer pageSize);

    @GetMapping("projectMessage/{id}")
    ProjectMessage getById(@RequestParam("id") Integer id);

    @GetMapping("projectMessage/getProjectMessageCount/{projectId}/{userId}")
    Integer getProjectMessageCount(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("userId") Integer userId);

    @GetMapping("projectMessage/getProjectMessageNeedToDoCount/{projectId}")
    Integer getProjectMessageNeedToDoCount(@RequestParam("projectId") Integer projectId);
}