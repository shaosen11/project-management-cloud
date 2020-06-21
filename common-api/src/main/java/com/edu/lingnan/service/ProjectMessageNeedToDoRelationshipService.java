package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectMessageNeedToDoRelationship;
import java.util.List;

/**
 * (ProjectMessageNeedToDoRelationship)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:17:52
 */
public interface ProjectMessageNeedToDoRelationshipService {

    /**
     * 通过消息id查询需要处理的事情
     *
     * @param projectMessageId
     * @return
     */
    ProjectMessageNeedToDoRelationship getByProjectMessageId(Integer projectMessageId);

    /**
     * 通过documentId查询需要处理的事情
     *
     * @param documentId
     * @return
     */
    ProjectMessageNeedToDoRelationship getByDocumentId(Integer documentId);

    /**
     * 插入一条关系
     *
     * @param projectsMessageNeedToDoRelationship
     */
    void insert(ProjectMessageNeedToDoRelationship projectsMessageNeedToDoRelationship);

}