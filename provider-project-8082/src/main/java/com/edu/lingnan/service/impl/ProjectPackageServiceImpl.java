package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectPackage;
import com.edu.lingnan.dao.ProjectPackageDao;
import com.edu.lingnan.service.ProjectPackageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectPackage)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:14
 */
@Service("projectPackageService")
public class ProjectPackageServiceImpl implements ProjectPackageService {
    @Resource
    private ProjectPackageDao projectPackageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectPackage queryById(Integer id) {
        return this.projectPackageDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectPackage> queryAllByLimit(int offset, int limit) {
        return this.projectPackageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectPackage 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectPackage insert(ProjectPackage projectPackage) {
        this.projectPackageDao.insert(projectPackage);
        return projectPackage;
    }

    /**
     * 修改数据
     *
     * @param projectPackage 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectPackage update(ProjectPackage projectPackage) {
        this.projectPackageDao.update(projectPackage);
        return this.queryById(projectPackage.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.projectPackageDao.deleteById(id) > 0;
    }
}