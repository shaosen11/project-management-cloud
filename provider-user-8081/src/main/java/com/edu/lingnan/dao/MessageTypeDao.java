package com.edu.lingnan.dao;

import com.edu.lingnan.entity.MessageType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (MessageType)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-12 14:59:13
 */
@Mapper
@Repository
public interface MessageTypeDao extends BaseDao<MessageType>{

    /**
     * 通过消息码得到消息类型
     * @param id
     * @return
     */
    MessageType getById(@Param("id") Integer id);


}