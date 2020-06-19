package com.edu.lingnan.service;

import com.edu.lingnan.entity.Project;

import java.util.List;

/**
 * (Project)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:17:24
 */
public interface ProjectService {

    Project queryById(Integer id);

    List<Project> queryAll(Project project);

    Project getById(Integer id);

    Project getByIdAndNoDel(Integer id);

    List<Project> getProjectList();

    List<Project> getProjectListByUserId(Integer userId);

    boolean deleteProject(Integer id);

    boolean reductionProject(Integer id);

    List<Project> getDelProjectList();

    Project getAdminByUserIdAndProjectId(Integer userId, Integer projectId);

    boolean insert(Project project);

    boolean update(Project project);

    Integer getProjectCount();

    List<Project> getAllDelProject();

    boolean updateProjectClickNumber(Integer projectId);


}