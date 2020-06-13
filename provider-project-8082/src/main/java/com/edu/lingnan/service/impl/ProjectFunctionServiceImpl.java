package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectFunction;
import com.edu.lingnan.dao.ProjectFunctionDao;
import com.edu.lingnan.feign.ProjectFunctionFeignService;
import com.edu.lingnan.service.ProjectFunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectFunction)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:16:42
 */
@Service("projectFunctionService")
public class ProjectFunctionServiceImpl implements ProjectFunctionService {
    @Resource
    private ProjectFunctionDao projectFunctionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectFunction queryById(Integer id) {
        return this.projectFunctionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectFunction> queryAllByLimit(int offset, int limit) {
        return this.projectFunctionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectFunction 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectFunction insert(ProjectFunction projectFunction) {
        this.projectFunctionDao.insert(projectFunction);
        return projectFunction;
    }

    /**
     * 修改数据
     *
     * @param projectFunction 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectFunction update(ProjectFunction projectFunction) {
        this.projectFunctionDao.update(projectFunction);
        return this.queryById(projectFunction.getId());
    }

}