package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectSchedule;
import com.edu.lingnan.dao.ProjectScheduleDao;
import com.edu.lingnan.feign.ProjectScheduleFeignService;
import com.edu.lingnan.service.ProjectScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectSchedule)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:29
 */
@Service("projectScheduleService")
public class ProjectScheduleServiceImpl implements ProjectScheduleService {
    @Resource
    private ProjectScheduleDao projectScheduleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectSchedule queryById(Integer id) {
        return this.projectScheduleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectSchedule> queryAllByLimit(int offset, int limit) {
        return this.projectScheduleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectSchedule 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectSchedule insert(ProjectSchedule projectSchedule) {
        this.projectScheduleDao.insert(projectSchedule);
        return projectSchedule;
    }

    /**
     * 修改数据
     *
     * @param projectSchedule 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectSchedule update(ProjectSchedule projectSchedule) {
        this.projectScheduleDao.update(projectSchedule);
        return this.queryById(projectSchedule.getId());
    }

}