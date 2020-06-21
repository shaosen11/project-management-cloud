package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Project;
import com.edu.lingnan.feign.ProjectFeignService;
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

    @PutMapping("reductionProject/{id}")
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



    @GetMapping("getProjectCount")
    public Integer getProjectCount() {
        return this.projectService.getProjectCount();
    }
    /**
     * 查询所有项目信息
     * @return 数据
     */
    @GetMapping("/queryAll")
    public List<Project> queryAll() {
        List<Project> list = projectService.queryAll(new Project());
        System.out.println("查询所有项目" + list);
        return list;
    }

    /**
     * 记录项目点击量
     * @return 数据
     */
    @RequestMapping(value = "/updateProjectClickCountById", method = RequestMethod.PUT)
    public Boolean updateProjectClickCountById(@RequestBody Integer projectId) {
        Project project = projectService.queryById(projectId);
        Integer num = project.getClickCount()+1;
        project.setClickCount(num);
        Boolean flag = projectService.update(project);
        return flag;
    }

    /**
     * 添加项目
     * @return 数据
     */
    @PostMapping("/")
    public Boolean addProject(@RequestBody Project project) {
        System.out.println("添加项目：" + project);
        return projectService.insert(project);
    }

    /**
     * 修改项目
     * @return 数据
     */
    @PutMapping("/")
    public Boolean updateProject(@RequestBody Project project) {
        System.out.println("修改项目：" + project);
        return projectService.update(project);
    }

    /**
     * 删除项目
     * @return 数据
     */
    @DeleteMapping("/{id}")
    public Boolean deleteProject(@PathVariable("id") Integer id){
        Project project = projectService.queryById(id);
        project.setDeleteFlag(0);
        return  projectService.update(project);
    }

    /**
     * 查询所有注销项目信息
     * @return 数据
     */
    @GetMapping("/getDeletedProject")
    public List<Project> getDeletedProject() {
        List<Project> list = projectService.getAllDelProject();
        return list;
    }

    /**
     * 还原用户项目
     * @return 数据
     */
    @RequestMapping(value = "/updateDelProjectById", method = RequestMethod.PUT)
    public Boolean updateDelProjectById(@RequestBody Integer id) {
        Project project = projectService.queryById(id);
        project.setDeleteFlag(1);
        return  projectService.update(project);
    }

    @PutMapping("updateProjectClickNumber/{projectId}")
    public boolean updateProjectClickNumber(Integer projectId){
        return projectService.updateProjectClickNumber(projectId);
    }
}