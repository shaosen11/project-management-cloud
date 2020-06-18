package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectUser;
import java.util.List;

/**
 * (ProjectUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:18:26
 */
public interface ProjectUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     * @param projectUser 实例对象
     * @return 实例对象
     */
    ProjectUser insert(ProjectUser projectUser);

    /**
     * 修改数据
     * @param projectUser 实例对象
     * @return 实例对象
     */
    ProjectUser update(ProjectUser projectUser);

    /**
     * 删除项目用户信息通过项目id
     * @param id 项目id
     * @return boolean
     */
    boolean deleteProjectUserByProjectsId(Integer id);

    /**
     * 通过用户Id和项目Id查询用户
     * @return ProjectUser
     */
    ProjectUser getByUserIdAndProjectId(Integer userId, Integer projectId);

}