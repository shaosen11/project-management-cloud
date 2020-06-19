package com.edu.lingnan.controller;

import com.edu.lingnan.entity.*;
import com.edu.lingnan.feign.*;
import com.edu.lingnan.utils.PathUtil;
import com.edu.lingnan.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {
    @Autowired
    private ProjectFeignService projectFeignService;

    @Autowired
    private SysUserFeignService sysUserFeignService;

    @Autowired
    private ProjectUserFeignService projectUserFeignService;

    @Autowired
    private ProjectFunctionFeignService projectFunctionFeignService;

    @Autowired
    private DocumentRecordFeignService documentRecordFeignService;

    @Autowired
    private ProjectCodeLineFeignService projectCodeLineFeignService;

    @Autowired
    private UserClickFeignService userClickFeignService;

    //查询一条项目信息
    @GetMapping("/get_by_id")
    public String getById(Integer id, Model model) {
        System.out.println("查询项目id:" + id);
        Project project = projectFeignService.getById(id);
        if (project != null) {
            model.addAttribute("projectmsg", project);
            System.out.println(project);
            return "echarts_test";
        } else {
            model.addAttribute("projectmsg", "此项目不存在");
            return "failure";
        }
    }

    //查询所有项目信息
    @GetMapping("/projects_list")
    public String projectList(Model model) {
        List<Project> list = projectFeignService.getProjectList();
        model.addAttribute("projectlist", list);
        System.out.println("查询所有项目" + list);
        return "tables/projectlist";
    }

    @GetMapping("/projects_view/{projectId}")
    public String projectView(HttpServletRequest request, @PathVariable("projectId") Integer projectId, Model model) {
        //记录点击量
        projectFeignService.updateProjectClickNumber(projectId);
        Date now = new Date();
        UserClick userClick1 = new UserClick();
        //获取myUserDetails对象
        MyUserDetails myUserDetails = UserUtil.getMyUserDetailsBySecurity(request);
        if (myUserDetails != null){
            userClick1.setUserId(myUserDetails.getId());
        }
        userClick1.setProjectId(projectId);
        userClick1.setClickTime(now);
        userClickFeignService.insert(userClick1);
        //获取项目信息
        Project project = projectFeignService.getById(projectId);
        model.addAttribute("project", project);
        model.addAttribute("projectId", projectId);
        return "project/projectview";
    }


    //添加项目
    @ResponseBody
    @PostMapping("/add_project")
    public Integer addProject(Project project) {
        System.out.println("待添加项目：" + project + " ChargeUserId=" + project.getChargeUserId());
        if (sysUserFeignService.getSysUser(project.getChargeUserId()) == null) {
            System.out.println("该项目负责人不存在");
            return 1;
        } else {
            project.setScheduleId(1);
            System.out.println("添加项目：" + project);
            Boolean flag = projectFeignService.addProject(project);
            if (flag) {
                System.out.println("添加项目成功！");
                return 2;
            } else {
                System.out.println("添加项目失败！");
                return 3;
            }
        }
    }

    //删除项目
    @Transactional
    @ResponseBody
    @PostMapping("/del_project")
    public Boolean deleteProject(Integer id) {
        try {
            projectUserFeignService.deleteProjectUserByProjectsId(id);
            projectFunctionFeignService.deleteProjectFunctionByProjectsId(id);
            projectFeignService.deleteProject(id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println("事务回滚，删除失败！");
            return false;
        }
        return true;
    }

    //修改项目信息
    @ResponseBody
    @PostMapping("/edit_project")
    public Integer editProject(Project project) {
        SysUser sysUser = sysUserFeignService.getSysUser(project.getChargeUserId());
        if (sysUser == null) {
            System.out.println("该项目负责人不存在");
            return 1;
        } else {
            System.out.println("editproject项目：" + project);
            Boolean flag = projectFeignService.updete(project);
            if (flag) {
                System.out.println("修改项目信息成功");
                return 2;
            } else {
                System.out.println("修改项目信息失败");
                return 3;
            }
        }
    }

    //查询所有注销项目信息
    @GetMapping("/del_project_list")
    public String deletedProjectList(Model model) {
        List<Project> list = projectFeignService.getDelProjectList();
        model.addAttribute("delprojectlist", list);
        System.out.println("查询所有已注销用户" + list);
        return "deleted/deleteproject";
    }

    //还原用户项目
    @ResponseBody
    @PostMapping("/reduction_project")
    public Boolean reductionProject(Integer id) {
        Boolean flag = projectFeignService.reductionProject(id);
        System.out.println("还原项目:" + id + flag);
        if (flag) {
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/newprojectview")
    public String newProjectView(HttpServletRequest request, Model model) {
        //1.从HttpServletRequest中获取SecurityContextImpl对象
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        //2.从SecurityContextImpl中获取Authentication对象
        Authentication authentication = securityContextImpl.getAuthentication();
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        System.out.println(userDetails);
        //我所有项目
        List<Myprojects> myprojectsList = sysUserFeignService.getMyProjectsByUserId(userDetails.getId());
        System.out.println("userid:" + userDetails.getId() + " 我的项目：" + myprojectsList);
        model.addAttribute("myprojects", myprojectsList);
        return "project/newprojectview";
    }

    @PostMapping("/projects")
    public String newProjects(Project project,HttpServletRequest request) {
        System.out.println(project);
        //设置项目初始状态
        project.setScheduleId(1);
        //插入数据库
        MyUserDetails myUserDetails = UserUtil.getMyUserDetailsBySecurity(request);
        project.setChargeUserId(myUserDetails.getId());
        projectFeignService.addProject(project);
        //插入projectuser表
        ProjectUser projectUser = new ProjectUser();
        projectUser.setProjectId(project.getId());
        projectUser.setUserId(myUserDetails.getId());
        projectUser.setDutyCode(1);
        projectUser.setJoinTime(new Date());
        projectUserFeignService.insert(projectUser);
        //插入project_code_line表
        ProjectCodeLine projectCodeLine = new ProjectCodeLine();
        projectCodeLine.setProjectId(project.getId());
        projectCodeLineFeignService.insert(projectCodeLine);
        Map<String, Object> pathMap = new HashMap<>();
        pathMap.put("projectId", project.getId());
        String pathString = PathUtil.pathUtil(pathMap);
        return "redirect:projects_view" + pathString;
    }

    @GetMapping("/project")
    @ResponseBody
    public Project getProjectByProjectId(Integer projectId) {
        return projectFeignService.getById(projectId);
    }

//    @GetMapping("/todayProjectsAndWeekProjects")
//    @ResponseBody
//    public Object getTodayProjectsAndWeekProjects() {
//        List todayProjectsList = projectFeignService.getTodayProject();
//        List weekProjectsList = projectFeignService.getWeekProject();
//        Map<String, List> projectMap = new HashMap<>();
//        projectMap.put("todayProjectsList", todayProjectsList);
//        projectMap.put("weekProjectsList", weekProjectsList);
//        return projectMap;
//    }
}

