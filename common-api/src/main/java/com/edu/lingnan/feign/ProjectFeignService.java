package com.edu.lingnan.feign;

import com.edu.lingnan.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Project)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:12:40
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface ProjectFeignService {

    @GetMapping("project/{id}")
    Project getById(@RequestParam("id") Integer id);

    @GetMapping("project/getByIdAndNoDel/{id}")
    Project getByIdAndNoDel(@RequestParam("id") Integer id);

    @GetMapping("project/getProjectList")
    List<Project> getProjectList();

    @GetMapping("project/getProjectListByUserId/{userId}")
    List<Project> getProjectListByUserId(@RequestParam("userId") Integer userId);

    @DeleteMapping("project/{id}")
    boolean deleteProject(@RequestParam("id") Integer id);

    @PutMapping("project/{id}")
    boolean reductionProject(@RequestParam("id") Integer id);

    @GetMapping("project/getDelProjectList")
    List<Project> getDelProjectList();

    @GetMapping("project/getAdminByUserIdAndProjectId/{userId}/{projectId}")
    Project getAdminByUserIdAndProjectId(
            @RequestParam("userId") Integer userId,
            @RequestParam("projectId") Integer projectId);

    @PostMapping("project/")
    boolean insert(Project project);

    @PutMapping("project/")
    boolean updete(Project project);

    @GetMapping("project/getProjectCount")
    Integer getProjectCount();

}