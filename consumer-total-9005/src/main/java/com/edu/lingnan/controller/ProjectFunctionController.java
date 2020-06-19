package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Project;
import com.edu.lingnan.feign.ProjectFeignService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 0:30 2020/6/20
 */
@Controller
public class ProjectFunctionController {

    @Autowired
    private ProjectFeignService projectFeignService;

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
}
