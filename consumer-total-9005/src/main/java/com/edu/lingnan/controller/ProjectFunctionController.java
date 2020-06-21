package com.edu.lingnan.controller;

import com.edu.lingnan.entity.*;
import com.edu.lingnan.exception.AJaxResponse;
import com.edu.lingnan.feign.*;
import com.edu.lingnan.utils.DateFromatUtil;
import com.edu.lingnan.utils.UserUtil;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private SysUserFeignService sysUserFeignService;

    @Autowired
    private ProjectUserFeignService projectUserFeignService;

    @Autowired
    private ProjectMessageFeignService projectMessageFeignService;

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


    /**
     * 获取功能点页面进度条数据
     *
     * @return Integer
     */
    @GetMapping("/getProjectFunctionDataCicleChart")
    @ResponseBody
    public Integer getProjectFunctionDataCicleChart(Integer projectId) {
        System.out.println("获取功能点页面进度条数据:" + projectId);
        Integer data = projectFunctionFeignService.getProjectFunctionDataCicleChart(projectId);
        System.out.println("获取功能点页面进度条数据:" + data);
        return data;
    }

    /**
     * 获取功能点页面各状态的功能点的数量
     *
     * @return Object
     */
    @PostMapping("/getProjectFunctionTotal")
    @ResponseBody
    public Object getProjectFunctionTotal(Integer projectId) {
        System.out.println("获取功能点页面各状态的功能点的数量:" + projectId);
        Map<String, Integer> map = projectFunctionFeignService.getProjectFunctionTotal(projectId);
        System.out.println("map=" + map);
        return map;
    }

    /**
     * 项目功能--全部功能
     *
     * @return ResponseEntity Integer projectId,Integer functionStatus
     */
    @PostMapping("/allFunctionPage")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> allFunctionPage(Integer page, ProjectFunction projectFunction) {
        System.out.println("项目功能--全部功能-->当前页：" + page + " 功能点=" + projectFunction);
        //4为已取消功能点
        if (projectFunction.getFunctionStatus() == 4) {
            projectFunction.setDeleteFlag(0);
            projectFunction.setFunctionStatus(null);
        } else {
            projectFunction.setDeleteFlag(1);
        }
        System.out.println("项目功能--全部功能-->查询功能点信息：" + projectFunction);
        ResponseEntity<Map<String, Object>> map = projectFunctionFeignService.allFunctionPage(page, projectFunction);
        System.out.println(map);
        return map;
    }

    /**
     * 项目功能--指派给我的
     *
     * @return ResponseEntity
     */
    @PostMapping("/assignFunctionPage")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> assignFunctionPage(Integer page, ProjectFunction projectFunction,HttpServletRequest request) {
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        System.out.println("项目功能--指派给我的-->当前页：" + page + " 功能点=" + projectFunction);
        //4为已取消功能点
        if (projectFunction.getFunctionStatus() == 4) {
            projectFunction.setDeleteFlag(0);
            projectFunction.setFunctionStatus(null);
        } else {
            projectFunction.setDeleteFlag(1);
        }
        projectFunction.setRealizeUserId(user.getId());
        System.out.println("项目功能--指派给我的-->查询功能点信息：" + projectFunction);
        ResponseEntity<Map<String, Object>> map = projectFunctionFeignService.assignFunctionPage(page, projectFunction);
        System.out.println(map);
        return map;
    }

    /**
     * 项目功能--我发布的
     *
     * @return ResponseEntity
     */
    @PostMapping("/publishFunctionPage")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> publishFunctionPage(Integer page, ProjectFunction projectFunction,HttpServletRequest request) {
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        System.out.println("项目功能--我发布的-->当前页：" + page + " 功能点=" + projectFunction);
        //4为已取消功能点
        if (projectFunction.getFunctionStatus() == 4) {
            projectFunction.setDeleteFlag(0);
            projectFunction.setFunctionStatus(null);
        } else {
            projectFunction.setDeleteFlag(1);
        }
        projectFunction.setPublishUserId(user.getId());
        System.out.println("项目功能--我发布的-->查询功能点信息：" + projectFunction);
        ResponseEntity<Map<String, Object>> map = projectFunctionFeignService.publishFunctionPage(page, projectFunction);
        System.out.println(map);
        return map;
    }

    /**
     * 项目功能--我参与的
     *
     * @return ResponseEntity
     */
    @RequestMapping(value = "/joinFunctionPage", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> joinFunctionPage(Integer page, ProjectFunction projectFunction,HttpServletRequest request) {
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        System.out.println("项目功能--我参与的::当前页：" + page + "  当前功能点：" + projectFunction);
        projectFunction.setPublishUserId(user.getId());
        projectFunction.setRealizeUserId(user.getId());
        System.out.println("项目功能--我参与的当前功能点：" + projectFunction);
        ResponseEntity<Map<String, Object>> map = projectFunctionFeignService.joinFunctionPage(page, projectFunction);
        System.out.println(map);
        return map;
    }


    /**
     * 去项目功能点计划页面
     *
     * @return 页面
     */
    @GetMapping("/toProjectsPlanView/{projectId}")
    public String toProjectsPlanView(@PathVariable("projectId") Integer projectId, Model model) {
        Project projects = projectFeignService.getById(projectId);
        model.addAttribute("project", projects);
        model.addAttribute("projectId", projectId);
        return "project/projectplanview";
    }

    /**
     * 获取项目计划的项目时间
     *
     * @return 页面
     */
    @GetMapping("/getProjectsPlanTime")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getProjectsPlanTime(Integer projectId) {
        System.out.println("getProjectsPlanTime--项目id=" + projectId);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Project projects = projectFeignService.getById(projectId);
            System.out.println("获得项目信息:" + projects);
            map.put("projects", projects);
            System.out.println("分页map" + map);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("获取数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 获取项目的所有功能点计划
     *
     * @return ResponseEntity
     */
    @GetMapping("/getProjectFunctionPlan")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getProjectFunctionPlan(Integer page, Integer projectId) {
        System.out.println("获取项目的所有功能点计划::page=" + page + "  projectId=" + projectId);
        ResponseEntity<Map<String, Object>> map = projectFunctionFeignService.getProjectFunctionPlan(page, projectId);
        System.out.println("获取项目的所有功能点计划::" + map);
        return map;
    }

    /**
     * 去到功能点详情页面
     *
     * @return ResponseEntity
     */
    @GetMapping("/project_function_detail_view/{projectFunctionId}")
    public String projectFunctionDetailView(@PathVariable("projectFunctionId") Integer projectFunctionId, Model model, HttpServletRequest request) {
        MyUserDetails user1 = UserUtil.getMyUserDetailsBySecurity(request);
        System.out.println("projectFunctionDetailView-->projectFunctionId=" + projectFunctionId);
        ProjectFunction projectsFunction = projectFunctionFeignService.queryById(projectFunctionId);
        Project project = projectFeignService.getById(projectsFunction.getProjectsId());
        SysUser user = sysUserFeignService.queryById(user1.getId());
        Integer role = 0;
        System.out.println("user.getId()=" + user.getId() + "  project.getId()=" + project.getId());
        if (user != null) {
            ProjectUser projectsUser = projectUserFeignService.getByUserIdAndProjectId(user.getId(), project.getId());
            System.out.println("projectFunctionDetailView-->" + projectsUser);
            if (projectsUser.getDutyCode() != 3) {
                //项目负责人或者管理员
                role = 1;
            } else if (user.getId().equals(projectsFunction.getRealizeUserId())) {
                //功能点实现者
                role = 2;
            }
        }
        model.addAttribute("projectsFunction", projectsFunction);
        model.addAttribute("project", project);
        model.addAttribute("projectId", projectsFunction.getProjectsId());
        model.addAttribute("role", role);
        return "project/projectfunctiondetailview";
    }

    /**
     * 功能点详情页面,获取功能点详情
     *
     * @return ProjectFunction
     */
    @GetMapping("/getProjectFunctionById")
    @ResponseBody
    public ProjectFunction getProjectFunctionById(Integer id) {
        System.out.println("getProjectFunctionById-->id=" + id);
        ProjectFunction projectsFunction = projectFunctionFeignService.queryById(id);
        System.out.println("getProjectFunctionById-->" + projectsFunction);
        return projectsFunction;
    }

    @GetMapping("/user_finish_function")
    @ResponseBody
    public List userFinishFunction(Integer projectId,HttpServletRequest request) {
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        Integer userId = user.getId();
        List<ProjectFunction> functionByProjectIdAndRealizeUserId1 = projectFunctionFeignService.getFunctionByProjectIdAndRealizeUserId(projectId, userId, 2);
        List<ProjectFunction> functionByProjectIdAndRealizeUserId2 = projectFunctionFeignService.getFunctionByProjectIdAndRealizeUserId(projectId, userId, 3);
        functionByProjectIdAndRealizeUserId1.addAll(functionByProjectIdAndRealizeUserId2);
        return functionByProjectIdAndRealizeUserId1;
    }

    @GetMapping("/user_developing_function")
    @ResponseBody
    public List userDevelopingFunction(Integer projectId,HttpServletRequest request) {
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        Integer userId = user.getId();
        return projectFunctionFeignService.getFunctionByProjectIdAndRealizeUserId(projectId, userId, 1);
    }

    @PostMapping("/projectFunctionMessageAlert")
    @ResponseBody
    public AJaxResponse projectFunctionMessageAlert(Integer functionId, Integer projectId, HttpServletRequest request) {
        MyUserDetails myUserDetails = UserUtil.getMyUserDetailsBySecurity(request);
        if (myUserDetails != null) {
            //项目是否存在此人
            ProjectUser projectsUser = projectUserFeignService.getByUserIdAndProjectId(myUserDetails.getId(), projectId);
            if (projectsUser != null) {
                //查询是否管理员或者功能点发布者
                if (projectsUser.getDutyCode() == 3) {
                    return AJaxResponse.error("你不是项目管理员，不可操作！");
                }
                //查找出项目功能点
                ProjectFunction function = projectFunctionFeignService.queryById(functionId);
                System.out.println(function);
                //封装信息
                ProjectMessage projectsMessage = new ProjectMessage();
                projectsMessage.setProjectId(projectId);
                projectsMessage.setFromUserId(myUserDetails.getId());
                projectsMessage.setToUserId(function.getRealizeUserId());
                projectsMessage.setTypeId(16);
                projectsMessage.setTime(DateFromatUtil.getNowDate(new Date()));
                String msg = projectsUser.getProjectUserDuty().getDutyName() + projectsUser.getMyUserDetails().getUsername()
                        + "提醒你尽快完成功能点" + function.getFunctionName();
                projectsMessage.setMessage(msg);
                System.out.println(projectsMessage);
                projectMessageFeignService.insert(projectsMessage);
                return AJaxResponse.success("提醒成功！");
            } else {
                return AJaxResponse.error("你不是管理员，没有权限！");
            }
        } else {
            return AJaxResponse.error("请先登录！");
        }
    }

    @GetMapping("/projectFunction")
    @ResponseBody
    public ProjectFunction projectFunctionById(Integer id){
        System.out.println(id);
        ProjectFunction projectsFunction = projectFunctionFeignService.queryById(id);
        System.out.println(projectsFunction);
        return projectsFunction;
    }

    @PutMapping("/projectFunction")
    @ResponseBody
    public AJaxResponse projectFunctionById(ProjectFunction projectsFunction){
        projectFunctionFeignService.editProjectFunction(projectsFunction);
        return AJaxResponse.success();
    }
}
