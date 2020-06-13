package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectMessageType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectMessageType)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:17:07
 */
@Mapper
@Repository
public interface ProjectMessageTypeDao extends BaseDao<ProjectMessageType>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectMessageType queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectMessageType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectMessageType 实例对象
     * @return 对象列表
     */
    List<ProjectMessageType> queryAll(ProjectMessageType projectMessageType);


}