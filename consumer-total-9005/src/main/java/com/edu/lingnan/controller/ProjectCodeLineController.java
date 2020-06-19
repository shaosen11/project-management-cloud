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

    @Autowired
    private ProjectFeignService projectFeignService;

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

    public boolean insert(Integer projectsId) {
        System.out.println("projectsId" + projectsId + "----------------------------------------");
        ProjectCodeLine projectCodeLine = projectCodeLineFeignService.getProjectCodeLineByProjectIdAndToday(projectsId);
        System.out.println("projectCodeLine:::" + projectCodeLine + "-------------------------------------------");
        //判断今天有没有记录
        if (projectCodeLine != null) {
            //有记录，修改记录
            projectCodeLine.setCodeLineNumber(projectFeignService.getById(projectsId).getCodeLineNumber());
            return projectCodeLineFeignService.update(projectCodeLine);
        } else {
            //新建对象
            ProjectCodeLine projectCodeLine1 = new ProjectCodeLine();
            projectCodeLine1.setProjectId(projectsId);
            projectCodeLine1.setCodeLineNumber(projectFeignService.getById(projectsId).getCodeLineNumber());
            return projectCodeLineFeignService.insert(projectCodeLine1);
        }
    }


}

