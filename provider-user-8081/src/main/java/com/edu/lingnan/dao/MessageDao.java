package com.edu.lingnan.dao;

import com.edu.lingnan.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Message)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-12 14:58:52
 */
@Mapper
@Repository
public interface MessageDao extends BaseDao<Message> {

    /**
     * 通过userId查询所有消息
     *
     * @param userId
     * @param needToDo
     * @return
     */
    List<Message> getByUserIdAndNeedToDo(@Param("userId") Integer userId, @Param("needToDo") Integer needToDo);

    /**
     * 通过userId查询所有消息
     *
     * @param userId
     * @param needToDo
     * @param offset
     * @param pageSize
     * @return
     */
    List<Message> getByUserIdAndOffsetAndPageSize(
            @Param("userId") Integer userId,
            @Param("needToDo") Integer needToDo,
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize);


    /**
     * 标记所有消息为已读
     *
     * @param userId
     * @param isRead
     * @return
     */
    boolean updateAllMessageIsReadByUserId(@Param("userId") Integer userId, @Param("isRead") Integer isRead);

    /**
     * 通过id查找消息
     *
     * @param id
     * @return
     */
    Message getById(Integer id);

    /**
     * 标记消息为已读
     *
     * @param messageId
     * @return
     */
    boolean updateMessageIsReadByMessageId(@Param("messageId") Integer messageId, @Param("isRead") Integer isRead);

    /**
     * 获取消息数量
     *
     * @param userId
     * @return
     */
    Integer getMessageCount(@Param("userId") Integer userId);

    /**
     * 获取待办消息数量
     *
     * @param userId
     * @return
     */
    Integer getMessageNeedToDoCount(@Param("userId") Integer userId);


}