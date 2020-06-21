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
public interface ProjectCodeLineDao extends BaseDao<ProjectCodeLine> {

    /**
     * 查询今天有没有记录
     *
     * @param projectsId
     * @return
     */
    ProjectCodeLine getProjectsCodeLineByProjectIdAndToday(@Param("projectId") Integer projectId);

    /**
     * 查询最近有没有记录
     *
     * @param projectsId
     * @return
     */
    ProjectCodeLine getProjectsCodeLineByProjectIdAndLastDay(@Param("projectId") Integer projectId);

    /**
     * 查询项目所有代码行记录
     *
     * @param projectId
     * @return
     */
    List<ProjectCodeLine> getAllProjectCodeLineByProjectId(@Param("projectId") Integer projectId);


}