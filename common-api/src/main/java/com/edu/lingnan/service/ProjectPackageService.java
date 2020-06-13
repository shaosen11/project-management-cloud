package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectPackage;
import java.util.List;

/**
 * (ProjectPackage)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:18:05
 */
public interface ProjectPackageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectPackage queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectPackage> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param projectPackage 实例对象
     * @return 实例对象
     */
    ProjectPackage insert(ProjectPackage projectPackage);

    /**
     * 修改数据
     *
     * @param projectPackage 实例对象
     * @return 实例对象
     */
    ProjectPackage update(ProjectPackage projectPackage);


}