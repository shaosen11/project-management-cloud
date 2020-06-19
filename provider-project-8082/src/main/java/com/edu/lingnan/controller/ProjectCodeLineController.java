package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectCodeLine;
import com.edu.lingnan.feign.ProjectCodeLineFeignService;
import com.edu.lingnan.service.ProjectCodeLineService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectCodeLine)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:16:33
 */
@RestController
@RequestMapping("projectCodeLine")
public class ProjectCodeLineController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectCodeLineService projectCodeLineService;

    @GetMapping("getProjectCodeLineByProjectIdAndToday/{projectId}")
    public ProjectCodeLine getProjectCodeLineByProjectIdAndToday(@PathVariable("projectId") Integer projectId){
        return projectCodeLineService.getProjectCodeLineByProjectIdAndToday(projectId);
    }

    @GetMapping("getProjectCodeLineByProjectIdAndLastDay/{projectId}")
    public ProjectCodeLine getProjectCodeLineByProjectIdAndLastDay(@PathVariable("projectId")Integer projectId){
        return projectCodeLineService.getProjectCodeLineByProjectIdAndLastDay(projectId);
    }

    @PostMapping("/")
    public boolean insert(ProjectCodeLine projectCodeLine){
        return projectCodeLineService.insert(projectCodeLine);
    }

    @PutMapping("/")
    public boolean update(ProjectCodeLine projectCodeLine){
        return projectCodeLineService.update(projectCodeLine);
    }

    @GetMapping("getAllProjectCodeLineByProjectId/{projectId}")
    public List<ProjectCodeLine> getAllProjectCodeLineByProjectId(@PathVariable("projectId") Integer projectId){
        return projectCodeLineService.getAllProjectCodeLineByProjectId(projectId);
    }

}