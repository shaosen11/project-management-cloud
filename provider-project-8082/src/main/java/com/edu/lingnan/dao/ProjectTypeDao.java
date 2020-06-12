package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectType)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:17:37
 */
@Mapper
@Repository
public interface ProjectTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectType queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectType 实例对象
     * @return 对象列表
     */
    List<ProjectType> queryAll(ProjectType projectType);

    /**
     * 新增数据
     *
     * @param projectType 实例对象
     * @return 影响行数
     */
    int insert(ProjectType projectType);

    /**
     * 修改数据
     *
     * @param projectType 实例对象
     * @return 影响行数
     */
    int update(ProjectType projectType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}