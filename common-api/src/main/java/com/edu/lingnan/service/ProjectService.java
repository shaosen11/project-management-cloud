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

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Project> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param project 实例对象
     * @return 实例对象
     */
    Project insert(Project project);

    /**
     * 修改数据
     *
     * @param project 实例对象
     * @return 实例对象
     */
    Project update(Project project);

    /**
     * 统计系统项目数量
     * @return
     */
    Integer projectCount();
}