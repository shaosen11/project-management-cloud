package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectUserDuty;
import com.edu.lingnan.feign.ProjectUserDutyFeignService;
import com.edu.lingnan.service.ProjectUserDutyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ProjectUserDuty)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:17:59
 */
@RestController
@RequestMapping("projectUserDuty")
public class ProjectUserDutyController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectUserDutyService projectUserDutyService;


}