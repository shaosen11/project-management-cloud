package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectMessageType;
import com.edu.lingnan.feign.ProjectMessageTypeFeignService;
import com.edu.lingnan.service.ProjectMessageTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectMessageType)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:17:07
 */
@RestController
@RequestMapping("projectMessageType")
public class ProjectMessageTypeController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectMessageTypeService projectMessageTypeService;

    @GetMapping("/{id}")
    public ProjectMessageType getById(Integer id){
        return projectMessageTypeService.getById(id);
    }


}