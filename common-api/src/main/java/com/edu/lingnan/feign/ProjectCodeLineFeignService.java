package com.edu.lingnan.feign;

import com.edu.lingnan.entity.ProjectCodeLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (ProjectCodeLine)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:12:46
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface ProjectCodeLineFeignService {

    @GetMapping("projectCodeLine/getProjectCodeLineByProjectIdAndToday/{projectId}")
    ProjectCodeLine getProjectCodeLineByProjectIdAndToday(@RequestParam("projectId") Integer projectId);

    @GetMapping("projectCodeLine/getProjectCodeLineByProjectIdAndLastDay/{projectId}")
     ProjectCodeLine getProjectCodeLineByProjectIdAndLastDay(@RequestParam("projectId")Integer projectId);

    @PostMapping("projectCodeLine/")
     boolean insert(ProjectCodeLine projectCodeLine);

    @PutMapping("projectCodeLine/")
     boolean update(ProjectCodeLine projectCodeLine);

    @GetMapping("projectCodeLine/getAllProjectCodeLineByProjectId/{projectId}")
     List<ProjectCodeLine> getAllProjectCodeLineByProjectId(@RequestParam("projectId") Integer projectId);
}