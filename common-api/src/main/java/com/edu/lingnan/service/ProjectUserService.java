package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectUser;
import java.util.List;

/**
 * (ProjectUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:14:09
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
     *
     * @param projectUser 实例对象
     * @return 实例对象
     */
    ProjectUser insert(ProjectUser projectUser);

    /**
     * 修改数据
     *
     * @param projectUser 实例对象
     * @return 实例对象
     */
    ProjectUser update(ProjectUser projectUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}