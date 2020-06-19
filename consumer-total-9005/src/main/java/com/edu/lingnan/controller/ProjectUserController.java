package com.edu.lingnan.controller;

import com.edu.lingnan.entity.*;
import com.edu.lingnan.feign.ProjectFeignService;
import com.edu.lingnan.feign.ProjectFunctionFeignService;
import com.edu.lingnan.feign.ProjectUserFeignService;
import com.edu.lingnan.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 19:55 2020/6/19
 */
@Controller
public class ProjectUserController {
    @Autowired
    private ProjectFeignService projectFeignService;

    @Autowired
    private ProjectUserFeignService projectUserFeignService;

    @Autowired
    private ProjectFunctionFeignService projectFunctionFeignService;

    @GetMapping("/getProjectsByUserId")
    @ResponseBody
    public List getProjectsByUserId(Integer userId) {
        return projectFeignService.getProjectListByUserId(userId);
    }

    @GetMapping("/getCodeDevoteData")//饼图1
    @ResponseBody
    public List getCodeDevoteData(Integer projectId) {
        return projectUserFeignService.getCodeDevote(projectId);
    }

    @GetMapping("/getCodeInsertData")//饼图2
    @ResponseBody
    public List getCodeInsertData(Integer projectId) {
        return projectUserFeignService.getCodeInsert(projectId);
    }

    @GetMapping("/project_user_view/{projectId}")
    public String projectUserView(@PathVariable("projectId") Integer projectId, Model model) {
        Project project = projectFeignService.getById(projectId);
        Integer countByProjectId = projectUserFeignService.getCountByProjectId(projectId);
        Integer managment = projectUserFeignService.getCountByProjectIdAndDuty(projectId, 1);
        Integer admin = projectUserFeignService.getCountByProjectIdAndDuty(projectId, 2);
        Integer codeDevelop = projectUserFeignService.getCountByProjectIdAndDuty(projectId, 3);
        model.addAttribute("countByProjectId", countByProjectId);
        model.addAttribute("admin", managment + admin);
        model.addAttribute("codeDevelop", codeDevelop);
        model.addAttribute("projectId", projectId);
        model.addAttribute("project", project);
        return "project/projectuserview";
    }

    @GetMapping("/project_user_cooperation_view/{projectId}")
    public String projectUserCooperationView(@PathVariable("projectId") Integer projectId, Model model) {
        Project project = projectFeignService.getById(projectId);
        model.addAttribute("projectId", projectId);
        model.addAttribute("project", project);
        return "project/projectusercooperationview";
    }

    /**
     * 判断用户是项目人员
     *
     * @param projectId
     * @param request
     * @return
     */
    @GetMapping("/projectUser")
    @ResponseBody
    public ProjectUser projectUser(Integer projectId, HttpServletRequest request) {
        MyUserDetails myUserDetails = UserUtil.getMyUserDetailsBySecurity(request);
        ProjectUser projectsUser = projectUserFeignService.getByUserIdAndProjectId(myUserDetails.getId(), projectId);
        return projectsUser;
    }

    /**
     * 判断用户是项目管理员或者功能点实现者或者功能点发布者
     *
     * @param projectId
     * @param request
     * @return
     */
    @GetMapping("/projectUserDuty")
    @ResponseBody
    public Integer projectsUserDuty(Integer projectId, Integer projectFunctionId, HttpServletRequest request) {
        MyUserDetails myUserDetails = UserUtil.getMyUserDetailsBySecurity(request);
        ProjectUser projectsUser = projectUserFeignService.getByUserIdAndProjectId(myUserDetails.getId(), projectId);
        Integer duty = 0;
        if (projectsUser.getProjectUserDuty().getId() != 3) {//管理员
            duty = 1;
        } else if(projectFunctionId != null){
            ProjectFunction projectsFunction = projectFunctionFeignService.queryById(projectFunctionId);
            if (projectsFunction.getRealizeUserId() == myUserDetails.getId() || projectsFunction.getPublishUserId() == myUserDetails.getId()) {
                duty = 2;
             }
        }
        return duty;
    }

    @GetMapping("/projectUsers")
    @ResponseBody
    public List projectUsers(Integer projectId) {
        return projectUserFeignService.getAllProjectUserByProjectId(projectId);
    }
}
