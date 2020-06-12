package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectFunction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectFunction)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:16:42
 */
@Mapper
@Repository
public interface ProjectFunctionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectFunction queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectFunction> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectFunction 实例对象
     * @return 对象列表
     */
    List<ProjectFunction> queryAll(ProjectFunction projectFunction);

    /**
     * 新增数据
     *
     * @param projectFunction 实例对象
     * @return 影响行数
     */
    int insert(ProjectFunction projectFunction);

    /**
     * 修改数据
     *
     * @param projectFunction 实例对象
     * @return 影响行数
     */
    int update(ProjectFunction projectFunction);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}