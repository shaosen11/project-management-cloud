package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectType;
import com.edu.lingnan.dao.ProjectTypeDao;
import com.edu.lingnan.service.ProjectTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectType)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:37
 */
@Service("projectTypeService")
public class ProjectTypeServiceImpl implements ProjectTypeService {
    @Resource
    private ProjectTypeDao projectTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectType queryById(Integer id) {
        return this.projectTypeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectType> queryAllByLimit(int offset, int limit) {
        return this.projectTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectType 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectType insert(ProjectType projectType) {
        this.projectTypeDao.insert(projectType);
        return projectType;
    }

    /**
     * 修改数据
     *
     * @param projectType 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectType update(ProjectType projectType) {
        this.projectTypeDao.update(projectType);
        return this.queryById(projectType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.projectTypeDao.deleteById(id) > 0;
    }
}