package com.edu.lingnan.dao;

import com.edu.lingnan.entity.UserStore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (UserStore)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:19:11
 */
@Mapper
@Repository
public interface UserStoreDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserStore queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserStore> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userStore 实例对象
     * @return 对象列表
     */
    List<UserStore> queryAll(UserStore userStore);

    /**
     * 新增数据
     *
     * @param userStore 实例对象
     * @return 影响行数
     */
    int insert(UserStore userStore);

    /**
     * 修改数据
     *
     * @param userStore 实例对象
     * @return 影响行数
     */
    int update(UserStore userStore);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}