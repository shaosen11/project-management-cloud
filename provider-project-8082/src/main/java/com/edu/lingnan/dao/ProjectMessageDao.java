package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectMessage)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:16:50
 */
@Mapper
@Repository
public interface ProjectMessageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectMessage queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectMessage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectMessage 实例对象
     * @return 对象列表
     */
    List<ProjectMessage> queryAll(ProjectMessage projectMessage);

    /**
     * 新增数据
     *
     * @param projectMessage 实例对象
     * @return 影响行数
     */
    int insert(ProjectMessage projectMessage);

    /**
     * 修改数据
     *
     * @param projectMessage 实例对象
     * @return 影响行数
     */
    int update(ProjectMessage projectMessage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}