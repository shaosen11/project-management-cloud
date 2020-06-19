package com.edu.lingnan.service;

import com.edu.lingnan.entity.MessageNeedToDoRelationship;
import java.util.List;

/**
 * (MessageNeedToDoRelationship)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:15:38
 */
public interface MessageNeedToDoRelationshipService {

    /**
     * 通过消息id查询需要处理的事情
     *
     * @param messageId
     * @return
     */
    MessageNeedToDoRelationship getByMessageId(Integer messageId);

    /**
     * 通过projectsUserCooperationId查询需要处理的事情
     *
     * @param projectsUserCooperationId
     * @return
     */
    MessageNeedToDoRelationship getByProjectsUserCooperationId(Integer projectsUserCooperationId);

    /**
     * 插入一条关系
     *
     * @param messageNeedToDoRelationship
     */
    boolean insert(MessageNeedToDoRelationship messageNeedToDoRelationship);

}