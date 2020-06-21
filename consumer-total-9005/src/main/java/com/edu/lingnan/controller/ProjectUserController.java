package com.edu.lingnan.controller;

import com.edu.lingnan.entity.*;
import com.edu.lingnan.feign.ProjectFeignService;
import com.edu.lingnan.feign.ProjectFunctionFeignService;
import com.edu.lingnan.feign.ProjectUserFeignService;
import com.edu.lingnan.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/getProjectByUserId")
    @ResponseBody
    public List getProjectByUserId(Integer userId) {
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
        ProjectUser projectUser = projectUserFeignService.getByUserIdAndProjectId(myUserDetails.getId(), projectId);
        return projectUser;
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
    public Integer projectUserDuty(Integer projectId, Integer projectFunctionId, HttpServletRequest request) {
        MyUserDetails myUserDetails = UserUtil.getMyUserDetailsBySecurity(request);
        ProjectUser projectUser = projectUserFeignService.getByUserIdAndProjectId(myUserDetails.getId(), projectId);
        Integer duty = 0;
        if (projectUser.getProjectUserDuty().getId() != 3) {//管理员
            duty = 1;
        } else if(projectFunctionId != null){
            ProjectFunction projectFunction = projectFunctionFeignService.queryById(projectFunctionId);
            if (projectFunction.getRealizeUserId() == myUserDetails.getId() || projectFunction.getPublishUserId() == myUserDetails.getId()) {
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

    /**
     * 加载项目人员和人才市场
     *
     * @param page
     * @param projectId
     * @param market
     * @return
     */
    @GetMapping("/projectUserPage")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> pages(Integer page, Integer projectId, Integer market) {
        Map<String, Object> map = new HashMap<String, Object>();
        int pageSize = 5;
        try {
            Integer count = null;
            if (market == null) {
                count = projectUserFeignService.getCountByProjectId(projectId);
            } else {
                count = projectUserFeignService.getCountNoInProjectByProjectId(projectId);
            }
            Integer totalPage = count / pageSize;
            if (count % pageSize != 0) {
                totalPage++;
            }
            if (page > totalPage) {
                return null;
            }
            int offset = (page - 1) * pageSize;
            List<ProjectUser> projectUserList = null;
            List<MyUserDetails> myUserDetailsList = null;
            if (market == null) {
                projectUserList = projectUserFeignService.getPageProjectUserByProjectId(projectId, offset, pageSize);
                map.put("list", projectUserList);
            } else {
                myUserDetailsList = projectUserFeignService.getProjectUserNoInProjectByProjectId(projectId, offset, pageSize);
                map.put("list", myUserDetailsList);
            }
            // 封装数据，并返回
            map.put("page", page);
            map.put("pageSize", pageSize);
            map.put("totalPage", totalPage);

            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("获取分页数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/projectUserDevotion/{projectId}/{userId}")
    @ResponseBody
    public ProjectUser projectUserDevotion(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("userId") Integer userId) {
        Project project = projectFeignService.getById(projectId);
        ProjectUser projectUser = projectUserFeignService.getByUserIdAndProjectId(userId, projectId);
        projectUser.setCodeDevoteLineRatio((double) projectUser.getCodeDevoteLine() / (double) project.getCodeLineNumber() * 100);
        projectUser.setCodeUpdateRatio((double) projectUser.getCodeUpdate() / (double) project.getCodeUpdateCount() * 100);
        return projectUser;
    }
}
