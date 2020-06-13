package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectPackage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectPackage)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:17:14
 */
@Mapper
@Repository
public interface ProjectPackageDao extends BaseDao<ProjectPackage>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectPackage queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectPackage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectPackage 实例对象
     * @return 对象列表
     */
    List<ProjectPackage> queryAll(ProjectPackage projectPackage);


}