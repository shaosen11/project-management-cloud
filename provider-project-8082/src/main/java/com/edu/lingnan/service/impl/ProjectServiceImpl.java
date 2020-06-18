package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.Project;
import com.edu.lingnan.dao.ProjectDao;
import com.edu.lingnan.feign.ProjectFeignService;
import com.edu.lingnan.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Project)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:15:23
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectDao projectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Project queryById(Integer id) {
        return this.projectDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Project> queryAllByLimit(int offset, int limit) {
        return this.projectDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Project> queryAll(Project project) {
        return this.projectDao.queryAll(project);
    }

    /**
     * 新增数据
     *
     * @param project 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(Project project) {
        return this.projectDao.insert(project) > 0;
    }

    /**
     * 修改数据
     *
     * @param project 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(Project project) {
        return this.projectDao.update(project);
    }

    @Override
    public List<Project> getAllDelProject() {
        return this.projectDao.getAllDelProject();
    }

    @Override
    public Integer projectCount() {
        return projectDao.projectCount();
    }

}