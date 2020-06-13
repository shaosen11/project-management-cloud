package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectCodeLine;
import java.util.List;

/**
 * (ProjectCodeLine)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:17:34
 */
public interface ProjectCodeLineService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectCodeLine queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectCodeLine> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param projectCodeLine 实例对象
     * @return 实例对象
     */
    ProjectCodeLine insert(ProjectCodeLine projectCodeLine);

    /**
     * 修改数据
     *
     * @param projectCodeLine 实例对象
     * @return 实例对象
     */
    ProjectCodeLine update(ProjectCodeLine projectCodeLine);


}