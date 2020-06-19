package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectMessage;
import com.edu.lingnan.dao.ProjectMessageDao;
import com.edu.lingnan.feign.ProjectMessageFeignService;
import com.edu.lingnan.service.ProjectMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectMessage)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:16:50
 */
@Service("projectMessageService")
public class ProjectMessageServiceImpl implements ProjectMessageService {
    @Resource
    private ProjectMessageDao projectMessageDao;


    @Override
    public List<ProjectMessage> getByProjectIdAndUserId(Integer projectId, Integer userId, Integer offset, Integer pageSize) {
        return projectMessageDao.getByProjectIdAndUserId(projectId, userId, offset, pageSize);
    }

    @Override
    public boolean insert(ProjectMessage projectsMessage) {
        return projectMessageDao.insert(projectsMessage) > 0;
    }

    @Override
    public List<ProjectMessage> getByProjectId(Integer projectId, Integer offset, Integer pageSize) {
        return projectMessageDao.getByProjectId(projectId, offset, pageSize);
    }

    @Override
    public boolean update(ProjectMessage projectsMessage) {
        return projectMessageDao.update(projectsMessage);
    }

    @Override
    public boolean updateProjectMessageIsReadByProjectMessageId(Integer projectMessageId) {
        return projectMessageDao.updateProjectMessageIsReadByProjectMessageId(projectMessageId);
    }

    @Override
    public List<ProjectMessage> getAllNeedToByProjectId(Integer projectId, Integer offset, Integer pageSize) {
        return projectMessageDao.getAllNeedToByProjectId(projectId, offset, pageSize);
    }

    @Override
    public ProjectMessage getById(Integer id) {
        return projectMessageDao.getById(id);
    }

    @Override
    public Integer getProjectMessageCount(Integer projectId, Integer userId) {
        return projectMessageDao.getProjectMessageCount(projectId, userId);
    }

    @Override
    public Integer getProjectMessageNeedToDoCount(Integer projectId) {
        return projectMessageDao.getProjectMessageNeedToDoCount(projectId);
    }
}