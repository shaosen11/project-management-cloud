package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectCodeLine;
import java.util.List;

/**
 * (ProjectCodeLine)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:17:34
 */
public interface ProjectCodeLineService {

    /**
     * 查询今天有没有记录
     * @param projectsId
     * @return
     */
    ProjectCodeLine getProjectCodeLineByProjectIdAndToday(Integer projectsId);

    /**
     * 查询最近有没有记录
     * @param projectsId
     * @return
     */
    ProjectCodeLine getProjectCodeLineByProjectIdAndLastDay(Integer projectsId);

    /**
     * 插入一条项目代码行记录
     * @param bean
     * @return
     */
    boolean insert(ProjectCodeLine bean);

    /**
     * 更新一条代码行记录
     * @param bean
     * @return
     */
    boolean update(ProjectCodeLine bean);

    /**
     * 查询项目所有代码行记录
     * @param projectId
     * @return
     */
    List<ProjectCodeLine> getAllProjectCodeLineByProjectId(Integer projectId);


}