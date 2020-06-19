package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Project;
import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.entity.UserClick;
import com.edu.lingnan.feign.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * (Project)表控制层
 *
 * @author makejava
 * @since 2020-06-11 23:21:30
 */
@Controller
@RequestMapping("project")
public class ProjectController {
    /**
     * 服务对象
     */
    @Autowired
    private ProjectFeignService projectFeignService;

    @Autowired
    private SysUserFeignService sysUserFeignService;

    @Autowired
    private UserClickFeignService userClickFeignService;

    @Autowired
    private ProjectUserFeignService projectUserFeignService;

    @Autowired
    private ProjectFunctionFeignService projectFunctionFeignService;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Project selectOne(@PathVariable("id") Integer id) {
        return this.projectFeignService.getById(id);
    }

    /**
     * 查询所有项目信息
     * @return 数据
     */
    @GetMapping("/queryAll")
    @ResponseBody
    public List<Project> queryAll() {
        return this.projectFeignService.queryAll();
    }

    /**
     * 项目页面
     * @return 数据
     */
    @GetMapping("/projectView/{projectId}")
    public String projectView(@PathVariable("projectId") Integer projectId,Model model) {
        //记录点击量
        System.out.println("projectId="+projectId);
        Boolean flag = projectFeignService.updateProjectClickCountById(projectId);
        System.out.println("记录点击量："+flag);
        Date now = new Date();
        UserClick userClick1 = new UserClick();
        //获取myUserDetails对象
        SysUser sysUser = sysUserFeignService.queryById(1);
        if (sysUser != null){
            userClick1.setUserId(sysUser.getId());
        }
        userClick1.setProjectsId(projectId);
        userClick1.setClickTime(now);
        userClickFeignService.insert(userClick1);
        //获取项目信息
        Project project2 = projectFeignService.getById(projectId);
        model.addAttribute("project", project2);
        model.addAttribute("projectId", projectId);
        return "project/projectview";
    }

    /**
     * 添加项目
     * @return 数据
     */
    @ResponseBody
    @PostMapping("/")
    public Integer addProject(Project project){
        System.out.println("待添加项目：" + project + " ChargeUserId=" + project.getChargeUserId());
        SysUser user = sysUserFeignService.queryById(project.getChargeUserId());
        System.out.println("项目负责人："+user);
        if (user == null) {
            System.out.println("该项目负责人不存在");
            return 1;
        } else {
            project.setScheduleId(1);
            System.out.println("添加项目：" + project);
            Boolean flag = projectFeignService.addProject(project);
            System.out.println(flag);
            if (flag) {
                System.out.println("添加项目成功！");
                return 2;
            } else {
                System.out.println("添加项目失败！");
                return 3;
            }
        }
    }

    /**
     * 删除项目
     * @return 数据
     */
    @Transactional
    @ResponseBody
    @DeleteMapping("/{id}")
    public Boolean deleteProject(@PathVariable("id") Integer id) {
        try {
            //删除项目相关的项目用户信息
            Boolean flag = projectUserFeignService.deleteProjectUserByProjectsId(id);
            System.out.println("删除项目相关的项目用户信息:"+flag);
            //删除相关的项目功能点信息
            Boolean flag2 = projectFunctionFeignService.deleteProjectFunctionByProjectsId(id);
            System.out.println("删除相关的项目功能点信息:"+flag2);
            //删除项目
            projectFeignService.deleteProject(id);
            System.out.println("删除的项目："+id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println("事务回滚，删除失败！");
            return false;
        }
        return true;
    }

    /**
     * 修改项目信息
     * @return 数据
     */
    @ResponseBody
    @PutMapping("/")
    public Integer updateProject(Project project) {
        SysUser user = sysUserFeignService.queryById(project.getChargeUserId());
        if (user == null) {
            System.out.println("该项目负责人不存在");
            return 1;
        } else {
            System.out.println("updateProject：" + project);
            Boolean flag = projectFeignService.updateProject(project);
            if (flag) {
                System.out.println("修改项目信息成功");
                return 2;
            } else {
                System.out.println("修改项目信息失败");
                return 3;
            }
        }
    }

    @GetMapping("toError")
    public String toError(){
        return "404";
    }

    /**
     * 查询所有注销项目信息
     * @return 数据
     */
    @GetMapping("/getDeletedProject")
    public String getDeletedProject(Model model) {
        List<Project> list = projectFeignService.getDeletedProject();
        model.addAttribute("delprojectlist", list);
        System.out.println("查询所有已注销用户" + list);
        return "deleted/deleteproject";
    }

    /**
     * 还原用户项目
     * @return 数据
     */
    @ResponseBody
    @PutMapping("/updateDelProjectById")
    public Boolean updateDelProjectById(Integer id) {
        Boolean flag = projectFeignService.updateDelProjectById(id);
        System.out.println("还原项目:" + id + flag);
        if (flag) {
            return true;
        } else {
            return false;
        }
    }


}