package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.Project;
import com.edu.lingnan.dao.ProjectDao;
import com.edu.lingnan.feign.ProjectFeignService;
import com.edu.lingnan.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Project)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:15:23
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectDao projectDao;


    @Override
    public Project queryById(Integer id) {
        return projectDao.getById(id);
    }

    @Override
    public List<Project> queryAll(Project project) {
        return this.projectDao.queryAll(project);
    }

    @Override
    public Project getById(Integer id) {
        return projectDao.getById(id);
    }

    @Override
    public Project getByIdAndNoDel(Integer id) {
        return projectDao.getByIdAndNoDel(id);
    }

    @Override
    public List<Project> getProjectList() {
        return projectDao.getProjectList();
    }

    @Override
    public List<Project> getProjectListByUserId(Integer userId) {
        return projectDao.getProjectListByUserId(userId);
    }

    @Override
    public boolean deleteProject(Integer id) {
        return projectDao.deleteProject(id);
    }

    @Override
    public boolean reductionProject(Integer id) {
        return projectDao.reductionProject(id);
    }

    @Override
    public List<Project> getDelProjectList() {
        return projectDao.getDelProjectList();
    }

    @Override
    public Project getAdminByUserIdAndProjectId(Integer userId, Integer projectId) {
        return null;
    }

    @Override
    public boolean insert(Project project) {
        return projectDao.insert(project) > 0;
    }

    @Override
    public boolean update(Project project) {
        return projectDao.update(project);
    }

    @Override
    public Integer getProjectCount(){
        return projectDao.getProjectCount();
    }

    @Override
    public List<Project> getAllDelProject() {
        return projectDao.getAllDelProject();
    }

    @Override
    public boolean updateProjectClickNumber(Integer projectId) {
        return projectDao.updateProjectClickNumber(projectId);
    }

}