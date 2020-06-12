package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectRecord;
import java.util.List;

/**
 * (ProjectRecord)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:13:52
 */
public interface ProjectRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectRecord queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param projectRecord 实例对象
     * @return 实例对象
     */
    ProjectRecord insert(ProjectRecord projectRecord);

    /**
     * 修改数据
     *
     * @param projectRecord 实例对象
     * @return 实例对象
     */
    ProjectRecord update(ProjectRecord projectRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}