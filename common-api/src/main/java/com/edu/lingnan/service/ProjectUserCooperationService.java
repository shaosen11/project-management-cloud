package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectUserCooperation;
import java.util.List;

/**
 * (ProjectUserCooperation)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:18:31
 */
public interface ProjectUserCooperationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectUserCooperation queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectUserCooperation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param projectUserCooperation 实例对象
     * @return 实例对象
     */
    ProjectUserCooperation insert(ProjectUserCooperation projectUserCooperation);

    /**
     * 修改数据
     *
     * @param projectUserCooperation 实例对象
     * @return 实例对象
     */
    ProjectUserCooperation update(ProjectUserCooperation projectUserCooperation);


}