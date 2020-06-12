package com.edu.lingnan.dao;

import com.edu.lingnan.entity.UserClick;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (UserClick)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:18:31
 */
@Mapper
@Repository
public interface UserClickDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserClick queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserClick> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userClick 实例对象
     * @return 对象列表
     */
    List<UserClick> queryAll(UserClick userClick);

    /**
     * 新增数据
     *
     * @param userClick 实例对象
     * @return 影响行数
     */
    int insert(UserClick userClick);

    /**
     * 修改数据
     *
     * @param userClick 实例对象
     * @return 影响行数
     */
    int update(UserClick userClick);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}