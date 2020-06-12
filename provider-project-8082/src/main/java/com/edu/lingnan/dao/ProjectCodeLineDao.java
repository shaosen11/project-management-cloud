package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectCodeLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectCodeLine)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:16:33
 */
@Mapper
@Repository
public interface ProjectCodeLineDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectCodeLine queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectCodeLine> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectCodeLine 实例对象
     * @return 对象列表
     */
    List<ProjectCodeLine> queryAll(ProjectCodeLine projectCodeLine);

    /**
     * 新增数据
     *
     * @param projectCodeLine 实例对象
     * @return 影响行数
     */
    int insert(ProjectCodeLine projectCodeLine);

    /**
     * 修改数据
     *
     * @param projectCodeLine 实例对象
     * @return 影响行数
     */
    int update(ProjectCodeLine projectCodeLine);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}