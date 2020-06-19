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

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Project queryById(Integer id);

    List<Project> queryAll(Project project);

    /**
     * 查询一条项目信息
     *
     * @return
     */
    Project getById(Integer id);

    /**
     * 查询一条没有被注销项目信息
     *
     * @return
     */
    Project getByIdAndNoDel(Integer id);

    /**
     * 查询所有项目信息
     *
     * @return
     */
    List<Project> getProjectList();

    /**
     * 通过userId查询所有项目
     *
     * @return
     */
    List<Project> getProjectListByUserId(Integer userId);


    /**
     * 删除项目
     *
     * @return
     */
    boolean deleteProject(Integer id);


    /**
     * 还原项目
     *
     * @return
     */
    boolean reductionProject(Integer id);

    /**
     * 查询所有已注销项目信息
     *
     * @return
     */
    List<Project> getDelProjectList();

    /**
     * 查找项目负责人
     *
     * @param userId
     * @param projectId
     * @return
     */
    Project getAdminByUserIdAndProjectId(Integer userId, Integer projectId);

    boolean insert(Project project);

    boolean update(Project project);

    Integer getProjectCount();


    List<Project> getAllDelProject();
}