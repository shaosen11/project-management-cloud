package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Project;
import com.edu.lingnan.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Project)表控制层
 *
 * @author makejava
 * @since 2020-06-11 23:21:05
 */
@RestController
@RequestMapping("project")
public class ProjectController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectService projectService;

    @GetMapping("/{id}")
    Project getById(@PathVariable("id") Integer id){
        return projectService.getById(id);
    }

    @GetMapping("getByIdAndNoDel/{id}")
    Project getByIdAndNoDel(@PathVariable("id") Integer id){
        return projectService.getByIdAndNoDel(id);
    }

    @GetMapping("getProjectList")
    List<Project> getProjectList(){
        return projectService.getProjectList();
    }

    @GetMapping("getProjectListByUserId/{userId}")
    List<Project> getProjectListByUserId(@PathVariable("userId") Integer userId){
        return projectService.getProjectListByUserId(userId);
    }

    @DeleteMapping("/{id}")
    boolean deleteProject(@PathVariable("id") Integer id){
        return projectService.deleteProject(id);
    }

    @PutMapping("/{id}")
    boolean reductionProject(@PathVariable("id") Integer id){
        return projectService.reductionProject(id);
    }

    @GetMapping("getDelProjectList")
    List<Project> getDelProjectList(){
        return projectService.getDelProjectList();
    }

    @GetMapping("getAdminByUserIdAndProjectId/{userId}/{projectId}")
    Project getAdminByUserIdAndProjectId(
            @PathVariable("userId") Integer userId,
            @PathVariable("projectId") Integer projectId){
        return projectService.getAdminByUserIdAndProjectId(userId, projectId);
    }

    @PostMapping("/")
    public boolean insert(Project project) {
        return projectService.insert(project);
    }

    @PutMapping("/")
    public boolean updete(Project project) {
        return projectService.update(project);
    }

    @GetMapping("getProjectCount")
    public Integer getProjectCount(){
        return projectService.getProjectCount();
    }
}