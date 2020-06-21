package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectMessageNeedToDoRelationship;
import com.edu.lingnan.dao.ProjectMessageNeedToDoRelationshipDao;
import com.edu.lingnan.feign.ProjectMessageNeedToDoRelationshipFeignService;
import com.edu.lingnan.service.ProjectMessageNeedToDoRelationshipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectMessageNeedToDoRelationship)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:16:59
 */
@Service("projectMessageNeedToDoRelationshipService")
public class ProjectMessageNeedToDoRelationshipServiceImpl implements ProjectMessageNeedToDoRelationshipService {
    @Resource
    private ProjectMessageNeedToDoRelationshipDao projectMessageNeedToDoRelationshipDao;

    @Override
    public ProjectMessageNeedToDoRelationship getByProjectMessageId(Integer projectMessageId) {
        return projectMessageNeedToDoRelationshipDao.getByProjectMessageId(projectMessageId);
    }

    @Override
    public ProjectMessageNeedToDoRelationship getByDocumentId(Integer documentId) {
        return projectMessageNeedToDoRelationshipDao.getByDocumentId(documentId);
    }

    @Override
    public void insert(ProjectMessageNeedToDoRelationship projectsMessageNeedToDoRelationship) {
        projectMessageNeedToDoRelationshipDao.insert(projectsMessageNeedToDoRelationship);
    }
}