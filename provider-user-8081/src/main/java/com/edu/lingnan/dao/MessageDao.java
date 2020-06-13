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
public interface MessageDao extends BaseDao<Message>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Message queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Message> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param message 实例对象
     * @return 对象列表
     */
    List<Message> queryAll(Message message);



}