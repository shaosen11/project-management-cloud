package com.edu.lingnan.service;

import com.edu.lingnan.entity.Message;
import java.util.List;

/**
 * (Message)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:12:08
 */
public interface MessageService {

    /**
     * 通过userId查询所有消息
     *
     * @param userId
     * @param needToDo
     * @return
     */
    List<Message> getByUserIdAndNeedToDo(Integer userId, Integer needToDo);

    /**
     * 通过userId查询所有消息
     * @param userId
     * @param needToDo
     * @param offset
     * @param pageSize
     * @return
     */
    List<Message> getByUserIdAndOffsetAndPageSize(Integer userId, Integer needToDo, Integer offset, Integer pageSize);

    /**
     * 插入一条消息
     *
     * @param message
     * @return
     */
    boolean insert(Message message);

    /**
     * 标记所有消息为已读
     *
     * @param userId
     * @param isRead
     * @return
     */
    boolean updateAllMessageIsReadByUserId(Integer userId, Integer isRead);


    /**
     * 通过id查找消息
     *
     * @param id
     * @return
     */
    Message getById(Integer id);

    /**
     * 更新消息
     *
     * @param message
     * @return
     */
    boolean update(Message message);

    /**
     * 标记消息为已读
     *
     * @param messageId
     * @return
     */
    boolean updateMessageIsReadByMessageId(Integer messageId, Integer isRead);

    /**
     * 获取消息数量
     *
     * @param userId
     * @return
     */
    Integer getMessageCount(Integer userId);

    /**
     * 获取待办消息数量
     *
     * @param userId
     * @return
     */
    Integer getMessageNeedToDoCount(Integer userId);


}