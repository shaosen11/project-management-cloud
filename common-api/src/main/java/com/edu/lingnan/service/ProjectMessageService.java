package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectMessage;
import java.util.List;

/**
 * (ProjectMessage)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:17:47
 */
public interface ProjectMessageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectMessage queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectMessage> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param projectMessage 实例对象
     * @return 实例对象
     */
    ProjectMessage insert(ProjectMessage projectMessage);

    /**
     * 修改数据
     *
     * @param projectMessage 实例对象
     * @return 实例对象
     */
    ProjectMessage update(ProjectMessage projectMessage);


}