package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.Echarts;
import com.edu.lingnan.entity.ProjectUser;
import com.edu.lingnan.dao.ProjectUserDao;
import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.service.ProjectUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:45
 */
@Service("projectUserService")
public class ProjectUserServiceImpl implements ProjectUserService {
    @Resource
    private ProjectUserDao projectUserDao;

    @Override
    public List<ProjectUser> getProjectUserList() {
        return projectUserDao.getProjectUserList();
    }

    @Override
    public ProjectUser getById(Integer id) {
        return projectUserDao.getById(id);
    }

    @Override
    public ProjectUser getDelById(Integer id) {
        return projectUserDao.getDelById(id);
    }

    @Override
    public boolean insert(ProjectUser projectUser) {
        return projectUserDao.insert(projectUser) > 0;
    }

    @Override
    public boolean deleteProjectUser(Integer id) {
        return projectUserDao.delete(id);
    }

    @Override
    public boolean deleteProjectUserByProjectsId(Integer projectsId) {
        return projectUserDao.deleteProjectUserByProjectsId(projectsId) > 0;
    }

    @Override
    public boolean update(ProjectUser projectsUser) {
        return projectUserDao.update(projectsUser);
    }

    @Override
    public boolean reductionProjectUser(Integer id) {
        return projectUserDao.reductionProjectUser(id);
    }

    @Override
    public List<ProjectUser> getDelProjectUserList() {
        return projectUserDao.getDelProjectUserList();
    }

    @Override
    public ProjectUser getByUserIdAndProjectId(Integer userId, Integer projectId) {
        return projectUserDao.getByUserIdAndProjectId(userId, projectId);
    }

    @Override
    public List<Echarts> getCodeDevote(Integer projectId) {
        return projectUserDao.getCodeDevote(projectId);
    }

    @Override
    public List<Echarts> getCodeInsert(Integer projectId) {
        return projectUserDao.getCodeInsert(projectId);
    }

    @Override
    public Integer getCountByProjectId(Integer projectId) {
        return projectUserDao.getCountByProjectId(projectId);
    }

    @Override
    public List<ProjectUser> getPageProjectUserByProjectId(Integer projectId, Integer offset, Integer pageSize) {
        return projectUserDao.getPageProjectUserByProjectId(projectId, offset, pageSize);
    }

    @Override
    public List<ProjectUser> getAllProjectUserByProjectId(Integer projectId) {
        return projectUserDao.getAllProjectUserByProjectId(projectId);
    }

    @Override
    public Integer getCountNoInProjectByProjectId(Integer projectId) {
        return projectUserDao.getCountNoInProjectByProjectId(projectId);
    }

    @Override
    public List<SysUser> getProjectUserNoInProjectByProjectId(Integer projectId, Integer offset, Integer pageSize) {
        return projectUserDao.getProjectUserNoInProjectByProjectId(projectId, offset, pageSize);
    }

    @Override
    public List<ProjectUser> getAllProjectByUserId(Integer userId) {
        return projectUserDao.getAllProjectByUserId(userId);
    }


    @Override
    public Integer getCountByProjectIdAndDuty(Integer projectId, Integer dutyCode) {
        return projectUserDao.getCountByProjectIdAndDuty(projectId, dutyCode);
    }

}