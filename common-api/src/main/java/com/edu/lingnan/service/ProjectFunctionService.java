package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectFunction;
import java.util.List;

/**
 * (ProjectFunction)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:13:23
 */
public interface ProjectFunctionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectFunction queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectFunction> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param projectFunction 实例对象
     * @return 实例对象
     */
    ProjectFunction insert(ProjectFunction projectFunction);

    /**
     * 修改数据
     *
     * @param projectFunction 实例对象
     * @return 实例对象
     */
    ProjectFunction update(ProjectFunction projectFunction);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}