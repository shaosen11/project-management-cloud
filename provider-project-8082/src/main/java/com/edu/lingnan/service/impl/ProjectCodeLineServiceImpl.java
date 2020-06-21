package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectCodeLine;
import com.edu.lingnan.dao.ProjectCodeLineDao;
import com.edu.lingnan.feign.ProjectCodeLineFeignService;
import com.edu.lingnan.service.ProjectCodeLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectCodeLine)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:16:33
 */
@Service("projectCodeLineService")
public class ProjectCodeLineServiceImpl implements ProjectCodeLineService {
    @Resource
    private ProjectCodeLineDao projectCodeLineDao;


    @Override
    public ProjectCodeLine getProjectCodeLineByProjectIdAndToday(Integer projectsId) {
        return projectCodeLineDao.getProjectsCodeLineByProjectIdAndToday(projectsId);
    }

    @Override
    public ProjectCodeLine getProjectCodeLineByProjectIdAndLastDay(Integer projectsId) {
        return projectCodeLineDao.getProjectsCodeLineByProjectIdAndLastDay(projectsId);
    }

    @Override
    public boolean insert(ProjectCodeLine projectCodeLine) {
        return projectCodeLineDao.insert(projectCodeLine) > 0;
    }

    @Override
    public boolean update(ProjectCodeLine projectCodeLine) {
        return projectCodeLineDao.update(projectCodeLine);
    }

    @Override
    public List<ProjectCodeLine> getAllProjectCodeLineByProjectId(Integer projectId) {
        return projectCodeLineDao.getAllProjectCodeLineByProjectId(projectId);
    }
}