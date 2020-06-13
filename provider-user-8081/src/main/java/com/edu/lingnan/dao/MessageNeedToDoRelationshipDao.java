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
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MessageNeedToDoRelationship queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MessageNeedToDoRelationship> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param messageNeedToDoRelationship 实例对象
     * @return 对象列表
     */
    List<MessageNeedToDoRelationship> queryAll(MessageNeedToDoRelationship messageNeedToDoRelationship);



}