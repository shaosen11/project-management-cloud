package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectUserCooperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectUserCooperation)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:17:51
 */
@Mapper
@Repository
public interface ProjectUserCooperationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectUserCooperation queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectUserCooperation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectUserCooperation 实例对象
     * @return 对象列表
     */
    List<ProjectUserCooperation> queryAll(ProjectUserCooperation projectUserCooperation);

    /**
     * 新增数据
     *
     * @param projectUserCooperation 实例对象
     * @return 影响行数
     */
    int insert(ProjectUserCooperation projectUserCooperation);

    /**
     * 修改数据
     *
     * @param projectUserCooperation 实例对象
     * @return 影响行数
     */
    int update(ProjectUserCooperation projectUserCooperation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}