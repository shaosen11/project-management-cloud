package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectUserDuty;
import com.edu.lingnan.dao.ProjectUserDutyDao;
import com.edu.lingnan.service.ProjectUserDutyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectUserDuty)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:59
 */
@Service("projectUserDutyService")
public class ProjectUserDutyServiceImpl implements ProjectUserDutyService {
    @Resource
    private ProjectUserDutyDao projectUserDutyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectUserDuty queryById(Integer id) {
        return this.projectUserDutyDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectUserDuty> queryAllByLimit(int offset, int limit) {
        return this.projectUserDutyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectUserDuty 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectUserDuty insert(ProjectUserDuty projectUserDuty) {
        this.projectUserDutyDao.insert(projectUserDuty);
        return projectUserDuty;
    }

    /**
     * 修改数据
     *
     * @param projectUserDuty 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectUserDuty update(ProjectUserDuty projectUserDuty) {
        this.projectUserDutyDao.update(projectUserDuty);
        return this.queryById(projectUserDuty.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.projectUserDutyDao.deleteById(id) > 0;
    }
}