package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectUserCooperation;
import com.edu.lingnan.dao.ProjectUserCooperationDao;
import com.edu.lingnan.service.ProjectUserCooperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectUserCooperation)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:51
 */
@Service("projectUserCooperationService")
public class ProjectUserCooperationServiceImpl implements ProjectUserCooperationService {
    @Resource
    private ProjectUserCooperationDao projectUserCooperationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectUserCooperation queryById(Integer id) {
        return this.projectUserCooperationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectUserCooperation> queryAllByLimit(int offset, int limit) {
        return this.projectUserCooperationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectUserCooperation 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectUserCooperation insert(ProjectUserCooperation projectUserCooperation) {
        this.projectUserCooperationDao.insert(projectUserCooperation);
        return projectUserCooperation;
    }

    /**
     * 修改数据
     *
     * @param projectUserCooperation 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectUserCooperation update(ProjectUserCooperation projectUserCooperation) {
        this.projectUserCooperationDao.update(projectUserCooperation);
        return this.queryById(projectUserCooperation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.projectUserCooperationDao.deleteById(id) > 0;
    }
}