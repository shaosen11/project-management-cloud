package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectSchedule;
import java.util.List;

/**
 * (ProjectSchedule)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:18:16
 */
public interface ProjectScheduleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectSchedule queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectSchedule> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param projectSchedule 实例对象
     * @return 实例对象
     */
    ProjectSchedule insert(ProjectSchedule projectSchedule);

    /**
     * 修改数据
     *
     * @param projectSchedule 实例对象
     * @return 实例对象
     */
    ProjectSchedule update(ProjectSchedule projectSchedule);


}