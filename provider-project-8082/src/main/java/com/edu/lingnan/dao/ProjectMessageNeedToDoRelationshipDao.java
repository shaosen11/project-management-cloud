package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectMessageNeedToDoRelationship;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectMessageNeedToDoRelationship)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:16:59
 */
@Mapper
@Repository
public interface ProjectMessageNeedToDoRelationshipDao extends BaseDao<ProjectMessageNeedToDoRelationship>{

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
    @Override
    int insert(ProjectMessageNeedToDoRelationship projectsMessageNeedToDoRelationship);

}