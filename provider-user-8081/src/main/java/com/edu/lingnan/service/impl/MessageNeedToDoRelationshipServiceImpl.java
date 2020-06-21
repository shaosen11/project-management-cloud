package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.MessageNeedToDoRelationship;
import com.edu.lingnan.dao.MessageNeedToDoRelationshipDao;
import com.edu.lingnan.feign.MessageNeedToDoRelationshipFeignService;
import com.edu.lingnan.service.MessageNeedToDoRelationshipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MessageNeedToDoRelationship)表服务实现类
 *
 * @author makejava
 * @since 2020-06-12 14:59:05
 */
@Service("messageNeedToDoRelationshipService")
public class MessageNeedToDoRelationshipServiceImpl implements MessageNeedToDoRelationshipService {
    @Resource
    private MessageNeedToDoRelationshipDao messageNeedToDoRelationshipDao;

    @Override
    public MessageNeedToDoRelationship getByMessageId(Integer messageId) {
        return messageNeedToDoRelationshipDao.getByMessageId(messageId);
    }

    @Override
    public MessageNeedToDoRelationship getByProjectsUserCooperationId(Integer projectsUserCooperationId) {
        return messageNeedToDoRelationshipDao.getByProjectsUserCooperationId(projectsUserCooperationId);
    }

    @Override
    public boolean insert(MessageNeedToDoRelationship messageNeedToDoRelationship) {
        return messageNeedToDoRelationshipDao.insert(messageNeedToDoRelationship) > 0;
    }

}