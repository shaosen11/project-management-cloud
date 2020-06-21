package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectCodeLine;
import com.edu.lingnan.feign.ProjectCodeLineFeignService;
import com.edu.lingnan.feign.ProjectFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 20:35 2020/4/3
 */
@Controller
public class ProjectCodeLineController {
    @Autowired
    private ProjectCodeLineFeignService projectCodeLineFeignService;

    /**
     * 项目总代码行折线图
     * @param projectId
     * @return
     */
    @GetMapping("/getLineChartDate")
    @ResponseBody
    public List getLineChartDate(Integer projectId) {
        List<ProjectCodeLine> projectCodeLines = projectCodeLineFeignService.getAllProjectCodeLineByProjectId(projectId);
        return projectCodeLines;
    }
}

