package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Project;
import com.edu.lingnan.entity.ProjectFunction;
import com.edu.lingnan.entity.ProjectUser;
import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.feign.ProjectFeignService;
import com.edu.lingnan.feign.ProjectFunctionFeignService;
import com.edu.lingnan.feign.ProjectUserFeignService;
import com.edu.lingnan.feign.SysUserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 10314
 */
@Controller
@RequestMapping("projectFunction")
public class ProjectFunctionController {
    @Autowired
    private ProjectFunctionFeignService projectFunctionFeignService;

    @Autowired
    private ProjectFeignService projectFeignService;

    @Autowired
    private SysUserFeignService sysUserFeignService;

    @Autowired
    private ProjectUserFeignService projectUserFeignService;

    @GetMapping("/toProjectFunctionView/{projectId}")
    public String toProjectFunctionView(@PathVariable("projectId") Integer projectId, Model model) {
        Project projects = projectFeignService.getById(projectId);
        model.addAttribute("project", projects);
        model.addAttribute("projectId", projectId);
        return "project/projectfunctionview";
    }

    /**
     * 获取功能点页面进度条数据
     * @return Integer
     */
    @GetMapping("/getProjectFunctionDataCicleChart")
    @ResponseBody
    public Integer getProjectFunctionDataCicleChart(Integer projectId) {
        System.out.println("获取功能点页面进度条数据:"+projectId);
        Integer data = projectFunctionFeignService.getProjectFunctionDataCicleChart(projectId);
        System.out.println("获取功能点页面进度条数据:"+data);
        return data;
    }

    /**
     * 获取功能点页面各状态的功能点的数量
     * @return Object
     */
    @PostMapping("/getProjectFunctionTotal")
    @ResponseBody
    public Object getProjectFunctionTotal(Integer projectId) {
        System.out.println("获取功能点页面各状态的功能点的数量:"+projectId);
        Map<String, Integer> map = projectFunctionFeignService.getProjectFunctionTotal(projectId);
        System.out.println("map="+map);
        return map;
    }

    /**
     * 项目功能--全部功能
     * @return ResponseEntity Integer projectId,Integer functionStatus
     */
    @PostMapping("/allFunctionPage")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> allFunctionPage(Integer page,ProjectFunction projectFunction) {
        System.out.println("项目功能--全部功能-->当前页：" + page +" 功能点="+projectFunction);
        //4为已取消功能点
        if(projectFunction.getFunctionStatus() == 4){
            projectFunction.setDeleteFlag(0);
            projectFunction.setFunctionStatus(null);
        }else{
            projectFunction.setDeleteFlag(1);
        }
        System.out.println("项目功能--全部功能-->查询功能点信息："+projectFunction);
        ResponseEntity<Map<String, Object>> map = projectFunctionFeignService.allFunctionPage(page,projectFunction);
        System.out.println(map);
        return map;
    }

    /**
     * 项目功能--指派给我的
     * @return ResponseEntity
     */
    @PostMapping("/assignFunctionPage")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> assignFunctionPage(Integer page,ProjectFunction projectFunction) {
        System.out.println("项目功能--指派给我的-->当前页：" + page +" 功能点="+projectFunction);
        //4为已取消功能点
        if(projectFunction.getFunctionStatus() == 4){
            projectFunction.setDeleteFlag(0);
            projectFunction.setFunctionStatus(null);
        }else{
            projectFunction.setDeleteFlag(1);
        }
        projectFunction.setRealizeUserId(16);
        System.out.println("项目功能--指派给我的-->查询功能点信息："+projectFunction);
        ResponseEntity<Map<String, Object>> map = projectFunctionFeignService.assignFunctionPage(page,projectFunction);
        System.out.println(map);
        return map;
    }

    /**
     * 项目功能--我发布的
     * @return ResponseEntity
     */
    @PostMapping("/publishFunctionPage")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> publishFunctionPage(Integer page,ProjectFunction projectFunction) {
        System.out.println("项目功能--我发布的-->当前页：" + page +" 功能点="+projectFunction);
        //4为已取消功能点
        if(projectFunction.getFunctionStatus() == 4){
            projectFunction.setDeleteFlag(0);
            projectFunction.setFunctionStatus(null);
        }else{
            projectFunction.setDeleteFlag(1);
        }
        projectFunction.setPublishUserId(16);
        System.out.println("项目功能--我发布的-->查询功能点信息："+projectFunction);
        ResponseEntity<Map<String, Object>> map = projectFunctionFeignService.publishFunctionPage(page,projectFunction);
        System.out.println(map);
        return map;
    }

    /**
     * 项目功能--我参与的
     * @return ResponseEntity
     */
    @RequestMapping(value = "/joinFunctionPage", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> joinFunctionPage(Integer page,ProjectFunction projectFunction) {
        System.out.println("项目功能--我参与的::当前页：" + page + "  当前功能点：" + projectFunction);
        projectFunction.setPublishUserId(16);
        projectFunction.setRealizeUserId(16);
        System.out.println("项目功能--我参与的当前功能点：" + projectFunction);
        ResponseEntity<Map<String, Object>> map = projectFunctionFeignService.joinFunctionPage(page,projectFunction);
        System.out.println(map);
        return map;
    }


    /**
     * 去项目功能点计划页面
     * @return 页面
     */
    @GetMapping("/toProjectsPlanView/{projectId}")
    public String projectPlanView(@PathVariable("projectId") Integer projectId, Model model) {
        Project projects = projectFeignService.getById(projectId);
        model.addAttribute("project", projects);
        model.addAttribute("projectId", projectId);
        return "project/projectplanview";
    }

    /**
     * 获取项目计划的项目时间
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
     * @return ResponseEntity
     */
    @GetMapping("/getProjectFunctionPlan")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getProjectFunctionPlan(Integer page,Integer projectId) {
        System.out.println("获取项目的所有功能点计划::page="+page+"  projectId="+projectId);
        ResponseEntity<Map<String, Object>> map = projectFunctionFeignService.getProjectFunctionPlan(page,projectId);
        System.out.println("获取项目的所有功能点计划::"+map);
        return map;
    }

    /**
     * 去到功能点详情页面
     * @return ResponseEntity
     */
    @GetMapping("/projectFunctionDetailView/{projectFunctionId}")
    public String projectFunctionDetailView(@PathVariable("projectFunctionId") Integer projectFunctionId, Model model, HttpServletRequest request){
        System.out.println("projectFunctionDetailView-->projectFunctionId="+projectFunctionId);
        ProjectFunction projectsFunction = projectFunctionFeignService.queryById(projectFunctionId);
        Project project = projectFeignService.getById(projectsFunction.getProjectsId());
        SysUser user = sysUserFeignService.queryById(16);
        Integer role = 0;
        System.out.println("user.getId()="+user.getId()+"  project.getId()="+project.getId());
        if(user != null){
            ProjectUser projectsUser = projectUserFeignService.getByUserIdAndProjectId(user.getId(),project.getId());
            System.out.println("projectFunctionDetailView-->"+projectsUser);
            if(projectsUser.getDutyCode() != 3){
                //项目负责人或者管理员
                role = 1;
            }else if(user.getId() == projectsFunction.getRealizeUserId()){
                //功能点实现者
                role = 2;
            }
        }
        model.addAttribute("projectsFunction", projectsFunction);
        model.addAttribute("project", project);
        model.addAttribute("projectId", projectsFunction.getProjectsId());
        model.addAttribute("role",role);
        return "project/projectfunctiondetailview";
    }

    /**
     * 功能点详情页面,获取功能点详情
     * @return ProjectFunction
     */
    @GetMapping("/getProjectFunctionById")
    @ResponseBody
    public ProjectFunction getProjectFunctionById(Integer id){
        System.out.println("getProjectFunctionById-->id="+id);
        ProjectFunction projectsFunction = projectFunctionFeignService.queryById(id);
        System.out.println("getProjectFunctionById-->"+projectsFunction);
        return projectsFunction;
    }
}
