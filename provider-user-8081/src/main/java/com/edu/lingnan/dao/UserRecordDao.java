package com.edu.lingnan.dao;

import com.edu.lingnan.entity.UserRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (UserRecord)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:19:02
 */
@Mapper
@Repository
public interface UserRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userRecord 实例对象
     * @return 对象列表
     */
    List<UserRecord> queryAll(UserRecord userRecord);

    /**
     * 新增数据
     *
     * @param userRecord 实例对象
     * @return 影响行数
     */
    int insert(UserRecord userRecord);

    /**
     * 修改数据
     *
     * @param userRecord 实例对象
     * @return 影响行数
     */
    int update(UserRecord userRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}