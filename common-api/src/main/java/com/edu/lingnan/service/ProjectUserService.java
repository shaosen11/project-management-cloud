package com.edu.lingnan.service;


import com.edu.lingnan.entity.Echarts;
import com.edu.lingnan.entity.ProjectUser;
import com.edu.lingnan.entity.SysUser;

import java.util.List;

/**
 * (ProjectUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:18:26
 */
public interface ProjectUserService {

    /**
     * 查询所有项目用户信息
     *
     * @return
     */
    List<ProjectUser> getProjectUserList();

    /**
     * 通过Id查询
     *
     * @return
     */
    ProjectUser getById(Integer id);

    /**
     * 通过Id查询已注销的记录
     *
     * @return
     */
    ProjectUser getDelById(Integer id);

    /**
     * 添加项目用户信息
     *
     * @param projectUser
     * @return
     */
    boolean insert(ProjectUser projectUser);

    /**
     * 删除项目用户信息
     *
     * @return
     */
    boolean deleteProjectUser(Integer id);

    /**
     * 删除项目用户信息通过项目id
     *
     * @return
     */
    boolean deleteProjectUserByProjectsId(Integer projectsId);

    /**
     * 修改项目用户信息
     *
     * @return
     */
    boolean update(ProjectUser projectUser);

    /**
     * 新增数据
     *
     * @param projectUser 实例对象
     * @return 实例对象
     */
    boolean reductionProjectUser(Integer id);

    /**
     * 修改数据
     *
     * @param projectUser 实例对象
     * @return 实例对象
     */
    List<ProjectUser> getDelProjectUserList();


    /**
     * 获取代码贡献量
     *
     * @param projectId
     * @return
     */
    List<Echarts> getCodeDevote(Integer projectId);

    /**
     * 获取代码上传次数
     *
     * @param projectId
     * @return
     */
    List<Echarts> getCodeInsert(Integer projectId);

    /**
     * 查询项目总共人数
     *
     * @param projectId
     * @return
     */
    Integer getCountByProjectId(Integer projectId);

    /**
     * 通过项目id查找分页项目成员
     *
     * @param projectId
     * @return
     */
    List<ProjectUser> getPageProjectUserByProjectId(Integer projectId, Integer offset, Integer pageSize);

    /**
     * 通过项目id查找所有项目成员
     *
     * @param projectId
     * @return
     */
    List<ProjectUser> getAllProjectUserByProjectId(Integer projectId);



    /**
     * 查询项目总共人数
     *
     * @param projectId
     * @return
     */
    Integer getCountNoInProjectByProjectId(Integer projectId);

    /**
     * 通过项目id查找不在项目的成员
     *
     * @param projectId
     * @return
     */
    List<SysUser> getProjectUserNoInProjectByProjectId(Integer projectId, Integer offset, Integer pageSize);

    /**
     * 通过userId查询
     *
     * @return
     */
    List<ProjectUser> getAllProjectByUserId(Integer userId);

    /**
     * 获取项目各类人数
     * @param projectId
     * @param dutyCode
     * @return
     */
    Integer getCountByProjectIdAndDuty(Integer projectId, Integer dutyCode);

    ProjectUser getByUserIdAndProjectId(Integer userId, Integer projectId);
}