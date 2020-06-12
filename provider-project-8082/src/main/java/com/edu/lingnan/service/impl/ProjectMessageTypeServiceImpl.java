package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectMessageType;
import com.edu.lingnan.dao.ProjectMessageTypeDao;
import com.edu.lingnan.service.ProjectMessageTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectMessageType)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:07
 */
@Service("projectMessageTypeService")
public class ProjectMessageTypeServiceImpl implements ProjectMessageTypeService {
    @Resource
    private ProjectMessageTypeDao projectMessageTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectMessageType queryById(Integer id) {
        return this.projectMessageTypeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectMessageType> queryAllByLimit(int offset, int limit) {
        return this.projectMessageTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectMessageType 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectMessageType insert(ProjectMessageType projectMessageType) {
        this.projectMessageTypeDao.insert(projectMessageType);
        return projectMessageType;
    }

    /**
     * 修改数据
     *
     * @param projectMessageType 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectMessageType update(ProjectMessageType projectMessageType) {
        this.projectMessageTypeDao.update(projectMessageType);
        return this.queryById(projectMessageType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.projectMessageTypeDao.deleteById(id) > 0;
    }
}