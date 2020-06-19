package com.edu.lingnan.feign;

import com.edu.lingnan.entity.Echarts;
import com.edu.lingnan.entity.ProjectUser;
import com.edu.lingnan.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (ProjectUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:14:09
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface ProjectUserFeignService {

    @GetMapping("projectUser/getProjectUserList")
    List<ProjectUser> getProjectUserList();

    @GetMapping("projectUser/{id}")
    ProjectUser getById(@RequestParam("id") Integer id);

    @GetMapping("projectUser/getDelById/{id}")
    ProjectUser getDelById(@RequestParam("id") Integer id);

    @PostMapping("projectUser/")
    boolean insert(ProjectUser projectUser);

    @DeleteMapping("projectUser/deleteProjectUser/{id}")
    boolean deleteProjectUser(@RequestParam("id") Integer id);

    @DeleteMapping("projectUser/deleteProjectUserByProjectsId/{projectId}")
    boolean deleteProjectUserByProjectsId(@RequestParam("projectId") Integer projectId);

    @PutMapping("projectUser/")
    boolean update(ProjectUser projectsUser);

    @PostMapping("projectUser/reductionProjectUser/{id}")
    boolean reductionProjectUser(@RequestParam("id") Integer id);

    @GetMapping("projectUser/getDelProjectUserList")
    List<ProjectUser> getDelProjectUserList();

    @GetMapping("projectUser/getByUserIdAndProjectId/{userId}/{projectId}")
    ProjectUser getByUserIdAndProjectId(@RequestParam("userId") Integer userId, @RequestParam("projectId") Integer projectId);

    @GetMapping("projectUser/getCodeDevote/{projectId}")
    List<Echarts> getCodeDevote(@RequestParam("projectId") Integer projectId);

    @GetMapping("projectUser/getCodeInsert/{projectId}")
    List<Echarts> getCodeInsert(@RequestParam("projectId") Integer projectId);

    @GetMapping("projectUser/getCountByProjectId/{projectId}")
    Integer getCountByProjectId(@RequestParam("projectId") Integer projectId);

    @GetMapping("projectUser/getPageProjectUserByProjectId/{projectId}/{offset}/{pageSize}")
    List<ProjectUser> getPageProjectUserByProjectId(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("offset") Integer offset,
            @RequestParam("pageSize") Integer pageSize);

    @GetMapping("projectUser/getAllProjectUserByProjectId/{projectId}")
    List<ProjectUser> getAllProjectUserByProjectId(@RequestParam("projectId") Integer projectId);

    @GetMapping("projectUser/getCountNoInProjectByProjectId/{projectId}")
    Integer getCountNoInProjectByProjectId(@RequestParam("projectId") Integer projectId);

    @GetMapping("projectUser/getProjectUserNoInProjectByProjectId")
    List<SysUser> getProjectUserNoInProjectByProjectId(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("offset") Integer offset,
            @RequestParam("pageSize") Integer pageSize);

    @GetMapping("projectUser/getAllProjectByUserId/{userId}")
    List<ProjectUser> getAllProjectByUserId(@RequestParam("userId") Integer userId);

    @GetMapping("projectUser/getCountByProjectIdAndDuty/{projectId}/{dutyCode}")
    Integer getCountByProjectIdAndDuty(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("dutyCode") Integer dutyCode);
}