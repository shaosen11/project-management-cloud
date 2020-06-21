package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Echarts;
import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.entity.ProjectUser;
import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.feign.ProjectUserFeignService;
import com.edu.lingnan.service.ProjectUserService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectUser)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:17:45
 */
@RestController
@RequestMapping("projectUser")
public class ProjectUserController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectUserService projectUserService;

    @GetMapping("/getProjectUserList")
    List<ProjectUser> getProjectUserList() {
        return projectUserService.getProjectUserList();
    }

    @GetMapping("/{id}")
    ProjectUser getById(@PathVariable("id") Integer id) {
        return projectUserService.getById(id);
    }

    @GetMapping("getDelById/{id}")
    ProjectUser getDelById(@PathVariable("id") Integer id) {
        return projectUserService.getDelById(id);
    }

    @PostMapping("/")
    boolean insert(ProjectUser projectUser) {
        return projectUserService.insert(projectUser);
    }

    @DeleteMapping("deleteProjectUser/{id}")
    boolean deleteProjectUser(@PathVariable("id") Integer id) {
        return projectUserService.deleteProjectUser(id);
    }

    @DeleteMapping("deleteProjectUserByProjectsId/{projectId}")
    boolean deleteProjectUserByProjectsId(@PathVariable("projectId") Integer projectId) {
        return projectUserService.deleteProjectUserByProjectsId(projectId);
    }

    @PutMapping("/")
    public boolean update(ProjectUser projectsUser) {
        return projectUserService.update(projectsUser);
    }

    @PostMapping("reductionProjectUser/{id}")
    boolean reductionProjectUser(@PathVariable("id") Integer id) {
        return projectUserService.reductionProjectUser(id);
    }

    @GetMapping("getDelProjectUserList")
    List<ProjectUser> getDelProjectUserList() {
        return projectUserService.getDelProjectUserList();
    }


    @GetMapping("getCodeDevote/{projectId}")
    List<Echarts> getCodeDevote(@PathVariable("projectId") Integer projectId) {
        return projectUserService.getCodeDevote(projectId);
    }

    @GetMapping("getCodeInsert/{projectId}")
    List<Echarts> getCodeInsert(@PathVariable("projectId") Integer projectId) {
        return projectUserService.getCodeInsert(projectId);
    }

    @GetMapping("getCountByProjectId/{projectId}")
    Integer getCountByProjectId(@PathVariable("projectId") Integer projectId) {
        return projectUserService.getCountByProjectId(projectId);
    }

    @GetMapping("getPageProjectUserByProjectId/{projectId}/{offset}/{pageSize}")
    List<ProjectUser> getPageProjectUserByProjectId(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("offset") Integer offset,
            @PathVariable("pageSize") Integer pageSize) {
        return projectUserService.getPageProjectUserByProjectId(projectId, offset, pageSize);
    }

    @GetMapping("getAllProjectUserByProjectId/{projectId}")
    List<ProjectUser> getAllProjectUserByProjectId(@PathVariable("projectId") Integer projectId) {
        return projectUserService.getAllProjectUserByProjectId(projectId);
    }

    @GetMapping("getCountNoInProjectByProjectId/{projectId}")
    Integer getCountNoInProjectByProjectId(@PathVariable("projectId") Integer projectId) {
        return projectUserService.getCountNoInProjectByProjectId(projectId);
    }

    @GetMapping("getProjectUserNoInProjectByProjectId/{projectId}/{offset}/{pageSize}")
    List<MyUserDetails> getProjectUserNoInProjectByProjectId(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("offset") Integer offset,
            @PathVariable("pageSize") Integer pageSize) {
        return projectUserService.getProjectUserNoInProjectByProjectId(projectId, offset, pageSize);
    }

    @GetMapping("getAllProjectByUserId/{userId}")
    List<ProjectUser> getAllProjectByUserId(@PathVariable("userId") Integer userId) {
        return projectUserService.getAllProjectUserByProjectId(userId);
    }

    @GetMapping("getCountByProjectIdAndDuty/{projectId}/{dutyCode}")
    Integer getCountByProjectIdAndDuty(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("dutyCode") Integer dutyCode) {
        return projectUserService.getCountByProjectIdAndDuty(projectId, dutyCode);
    }


    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @GetMapping("/getByUserIdAndProjectId/{userId}/{projectId}")
    public ProjectUser getByUserIdAndProjectId(
            @PathVariable("userId") Integer userId,
            @PathVariable("projectId") Integer projectId) {
        ProjectUser projectUser = projectUserService.getByUserIdAndProjectId(userId, projectId);
        System.out.println(projectUser);
        return projectUser;
    }

}