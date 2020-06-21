package com.edu.lingnan.dao;

import com.edu.lingnan.entity.MessageNeedToDoRelationship;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (MessageNeedToDoRelationship)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-12 14:59:05
 */
@Mapper
@Repository
public interface MessageNeedToDoRelationshipDao extends BaseDao<MessageNeedToDoRelationship>{

    /**
     * 通过消息id查询需要处理的事情
     *
     * @param messageId
     * @return
     */
    MessageNeedToDoRelationship getByMessageId(@Param("messageId") Integer messageId);

    /**
     * 通过projectsUserCooperationId查询需要处理的事情
     *
     * @param projectsUserCooperationId
     * @return
     */
    MessageNeedToDoRelationship getByProjectsUserCooperationId(Integer projectsUserCooperationId);




}