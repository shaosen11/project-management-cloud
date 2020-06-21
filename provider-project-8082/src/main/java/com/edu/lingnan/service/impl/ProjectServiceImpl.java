package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.MyProject;
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
    public List<Project> queryAllByLimit(int offset, int limit) {
        return projectDao.queryAllByLimit(offset,limit);
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
    public Boolean insert(Project project) {
        return projectDao.insert(project) > 0;
    }

    @Override
    public Boolean update(Project project) {
        return projectDao.update(project);
    }

    @Override
    public Integer getProjectCount(){
        return projectDao.getProjectCount();
    }

    @Override
    public Integer projectCount() {
        return projectDao.projectCount();
    }

    @Override
    public List<Project> getAllDelProject() {
        return projectDao.getAllDelProject();
    }

    @Override
    public boolean updateProjectClickNumber(Integer projectId) {
        return projectDao.updateProjectClickNumber(projectId);
    }

    @Override
    public Integer getMyProjectNumBySchedule(Integer userId, Integer scheduleId) {
        return projectDao.getMyProjectNumBySchedule(userId,scheduleId);
    }

    @Override
    public Integer getMyChargeProjectNumBySchedule(Integer userId, Integer scheduleId) {
        return projectDao.getMyChargeProjectNumBySchedule(userId,scheduleId);
    }

    @Override
    public Integer getMyJoinProjectNumBySchedule(Integer userId, Integer scheduleId) {
        return projectDao.getMyJoinProjectNumBySchedule(userId,scheduleId);
    }

    @Override
    public Integer getMyAllProjectNum(Integer userId) {
        return projectDao.getMyAllProjectNum(userId);
    }

    @Override
    public Integer getMyChargeProjectNum(Integer userId) {
        return projectDao.getMyChargeProjectNum(userId);
    }

    @Override
    public Integer getMyJoinProjectNum(Integer userId) {
        return projectDao.getMyJoinProjectNum(userId);
    }

    @Override
    public List<MyProject> getMyAllProjectPage(Integer userId, Integer offset, Integer pageSize) {
        return projectDao.getMyAllProjectPage(userId,offset,pageSize);
    }

    @Override
    public List<MyProject> getMyChargeProjectPage(Integer userId, Integer offset, Integer pageSize) {
        return projectDao.getMyChargeProjectPage(userId,offset,pageSize);
    }

    @Override
    public List<MyProject> getMyJoinProjectPage(Integer userId, Integer offset, Integer pageSize) {
        return projectDao.getMyJoinProjectPage(userId,offset,pageSize);
    }

    @Override
    public List<MyProject> queryMyProjectPageByTypeOrSchedule(int offset, int limit, MyProject myProject,Integer userId) {
        return projectDao.queryMyProjectPageByTypeOrSchedule(offset,limit,myProject,userId);
    }

    @Override
    public List<MyProject> queryMyProjectByTypeOrSchedule(MyProject myProject,Integer userId) {
        return projectDao.queryMyProjectByTypeOrSchedule(myProject,userId);
    }

    @Override
    public List<MyProject> queryMyProjectPageByTypeOrSchedule2(int offset, int limit, MyProject myProject,Integer userId) {
        return projectDao.queryMyProjectPageByTypeOrSchedule2(offset,limit,myProject,userId);
    }

    @Override
    public List<MyProject> queryMyProjectByTypeOrSchedule2(MyProject myProject,Integer userId) {
        return projectDao.queryMyProjectByTypeOrSchedule2(myProject,userId);
    }

    @Override
    public List<MyProject> queryMyProjectPageByFuzzySearch(int offset, int limit, String content, Integer userId,Integer chargeUserId) {
        return projectDao.queryMyProjectPageByFuzzySearch(offset,limit,content,userId,chargeUserId);
    }

    @Override
    public List<MyProject> queryMyProjectByFuzzySearch(String content, Integer userId,Integer chargeUserId) {
        return projectDao.queryMyProjectByFuzzySearch(content,userId,chargeUserId);
    }

    @Override
    public List<MyProject> queryMyProjectPageByFuzzySearch2(int offset, int limit, String content, Integer userId,Integer chargeUserId) {
        return projectDao.queryMyProjectPageByFuzzySearch2(offset,limit,content,userId,chargeUserId);
    }

    @Override
    public List<MyProject> queryMyProjectByFuzzySearch2(String content, Integer userId,Integer chargeUserId) {
        return projectDao.queryMyProjectByFuzzySearch2(content,userId,chargeUserId);
    }

    @Override
    public Integer getMyProjectStoreNumByUserId(Integer userId) {
        return projectDao.getMyProjectStoreNumByUserId(userId);
    }

    @Override
    public List<MyProject> getMyProjectStorePageByUserId(Integer userId, Integer offset, Integer pageSize) {
        return projectDao.getMyProjectStorePageByUserId(userId,offset,pageSize);
    }

}