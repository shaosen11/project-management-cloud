package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Project;
import com.edu.lingnan.entity.ProjectFunction;
import com.edu.lingnan.feign.ProjectFeignService;
import com.edu.lingnan.feign.ProjectFunctionFeignService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 0:30 2020/6/20
 */
@Controller
public class ProjectFunctionController {

    @Autowired
    private ProjectFeignService projectFeignService;

    @Autowired
    private ProjectFunctionFeignService projectFunctionFeignService;

    @GetMapping("/projects_plan_view/{projectId}")
    public String projectPlanView(@PathVariable("projectId") Integer projectId, Model model) {
        Project project = projectFeignService.getById(projectId);
        model.addAttribute("project", project);
        model.addAttribute("projectId", projectId);
        return "project/projectplanview";
    }

    @GetMapping("/project_function_view/{projectId}")
    public String projectView(@PathVariable("projectId") Integer projectId, Model model) {
        Project project = projectFeignService.getById(projectId);
        model.addAttribute("project", project);
        model.addAttribute("projectId", projectId);
        return "project/projectfunctionview";
    }

//    @GetMapping("/user_finish_function")
//    @ResponseBody
//    public List userFinishFunction(Integer projectId, Integer userId) {
//        List<ProjectFunction> functionByProjectIdAndRealizeUserId1 = projectFunctionFeignService.getFunctionByProjectIdAndRealizeUserId(projectId, userId, 2);
//        List<ProjectFunction> functionByProjectIdAndRealizeUserId2 = projectFunctionFeignService.getFunctionByProjectIdAndRealizeUserId(projectId, userId, 3);
//        functionByProjectIdAndRealizeUserId1.addAll(functionByProjectIdAndRealizeUserId2);
//        return functionByProjectIdAndRealizeUserId1;
//    }
//
//    @GetMapping("/user_developing_function")
//    @ResponseBody
//    public List userDevelopingFunction(Integer projectId, Integer userId) {
//        return projectFunctionFeignService.getFunctionByProjectIdAndRealizeUserId(projectId, userId, 1);
//    }
}
