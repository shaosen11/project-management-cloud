package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectPackage;
import com.edu.lingnan.feign.ProjectPackageFeignService;
import com.edu.lingnan.service.ProjectPackageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectPackage)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:17:14
 */
@RestController
@RequestMapping("projectPackage")
public class ProjectPackageController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectPackageService projectPackageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProjectPackage selectOne(Integer id) {
        return this.projectPackageService.queryById(id);
    }

}