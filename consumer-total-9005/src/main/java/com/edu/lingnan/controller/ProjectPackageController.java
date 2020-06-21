package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Document;
import com.edu.lingnan.entity.Project;
import com.edu.lingnan.entity.ProjectPackage;
import com.edu.lingnan.entity.ProjectPackageList;
import com.edu.lingnan.feign.ProjectFeignService;
import com.edu.lingnan.feign.ProjectPackageFeignService;
import com.edu.lingnan.service.ProjectService;
import com.edu.lingnan.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 11:11 2020/6/20
 */
@Controller
public class ProjectPackageController {

    @Autowired
    private ProjectPackageFeignService projectPackageFeignService;

    @Autowired
    private ProjectFeignService projectFeignService;

    @GetMapping("/projectPackages")
    @ResponseBody
    public List<ProjectPackageList> getAllPackageByProjectIdAndPackageId(@RequestParam("projectId") Integer projectId) {
        //通过projectId查询项目的所有包
        List<ProjectPackageList> list = projectPackageFeignService.getAllPackagesListByProjectId(projectId);
        return list;
    }

    @PostMapping("/projectPackage")
    public String addPackage(ProjectPackage projectPackage) {
        //创建projectPackage对象
        System.out.println(projectPackage);
        //处理包id
        //还没有存在包
        Integer packageId = null;
        ProjectPackage packageIdByProjectId = projectPackageFeignService.getPackageIdByProjectId(projectPackage.getProjectId());
        if(packageIdByProjectId == null){
            packageId = 1;
        }else {
            packageId = packageIdByProjectId.getPackageId() + 1;
        }
        System.out.println("packageId:::" + packageId);
        projectPackage.setPackageId(packageId);
        projectPackageFeignService.insert(projectPackage);
        //修改项目最近更新时间
        Project project = projectFeignService.getById(projectPackage.getProjectId());
        project.setLastUpdateTime(new Date());
        projectFeignService.updete(project);
        Map<String,Object> pathMap = new HashMap<>();
        pathMap.put("projectId", projectPackage.getProjectId());
        pathMap.put("userId", projectPackage.getUserId());
        String pathString = PathUtil.pathUtil(pathMap);
        return "redirect:project_view" + pathString;
    }

    @ResponseBody
    @GetMapping("/projectPackage")
    public boolean checkPackageByProjectIdAndPackageName(ProjectPackage projectPackage){
        System.out.println(projectPackage);
        if(projectPackageFeignService.getPackageByProjectIdAndPackageName(projectPackage.getProjectId(), projectPackage.getPackageName()) == null){
            return true;
        }else {
            return false;
        }
    }

}
