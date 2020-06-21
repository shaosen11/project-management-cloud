package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.Message;
import com.edu.lingnan.dao.MessageDao;
import com.edu.lingnan.feign.MessageFeignService;
import com.edu.lingnan.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Message)表服务实现类
 *
 * @author makejava
 * @since 2020-06-12 14:58:52
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public List<Message> getByUserIdAndNeedToDo(Integer userId, Integer needToDo) {
        return messageDao.getByUserIdAndNeedToDo(userId, needToDo);
    }

    @Override
    public List<Message> getByUserIdAndOffsetAndPageSize(Integer userId, Integer needToDo, Integer offset, Integer pageSize) {
        return messageDao.getByUserIdAndOffsetAndPageSize(userId, needToDo, offset, pageSize);
    }


    @Override
    public boolean insert(Message message) {
        return messageDao.insert(message) > 0;
    }

    @Override
    public boolean updateAllMessageIsReadByUserId(Integer userId, Integer isRead) {
        return messageDao.updateAllMessageIsReadByUserId(userId, isRead);
    }

    @Override
    public Message getById(Integer id) {
        return messageDao.getById(id);
    }

    @Override
    public boolean update(Message message) {
        return messageDao.update(message);
    }

    @Override
    public boolean updateMessageIsReadByMessageId(Integer messageId, Integer isRead) {
        return messageDao.updateMessageIsReadByMessageId(messageId, isRead);
    }

    @Override
    public Integer getMessageCount(Integer userId) {
        return messageDao.getMessageCount(userId);
    }

    @Override
    public Integer getMessageNeedToDoCount(Integer userId) {
        return messageDao.getMessageNeedToDoCount(userId);
    }


}