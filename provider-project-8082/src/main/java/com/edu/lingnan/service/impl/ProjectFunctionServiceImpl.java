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
    public List<ProjectFunction> queryAllByLimit(int offset, int limit,ProjectFunction projectFunction) {
        return this.projectFunctionDao.queryAllByLimit(offset, limit,projectFunction);
    }

    @Override
    public List<ProjectFunction> queryAll(ProjectFunction projectFunction) {
        return this.projectFunctionDao.queryAll(projectFunction);
    }

    @Override
    public List<ProjectFunction> queryAllByLimitByUserId(int offset, int limit, ProjectFunction projectFunction) {
        return this.projectFunctionDao.queryAllByLimitByUserId(offset, limit,projectFunction);
    }

    @Override
    public List<ProjectFunction> queryAllByUserId(ProjectFunction projectFunction) {
        return this.projectFunctionDao.queryAllByUserId(projectFunction);
    }

    @Override
    public List<ProjectFunction> queryDelByLimitByUserId(int offset, int limit, ProjectFunction projectFunction) {
        return this.projectFunctionDao.queryDelByLimitByUserId(offset, limit,projectFunction);
    }

    @Override
    public List<ProjectFunction> queryDelByUserId(ProjectFunction projectFunction) {
        return this.projectFunctionDao.queryDelByUserId(projectFunction);
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
     * @param projectFunction 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectFunction update(ProjectFunction projectFunction) {
        this.projectFunctionDao.update(projectFunction);
        return this.queryById(projectFunction.getId());
    }

    /**
     * 删除项目功能点信息通过ProjectsId
     * @return boolean
     */
    @Override
    public boolean deleteProjectFunctionByProjectsId(Integer id) {
        return this.projectFunctionDao.deleteProjectFunctionByProjectsId(id)>0;
    }

    @Override
    public Integer countProjectFunctionByProjectId(Integer id) {
        return this.projectFunctionDao.countProjectFunctionByProjectId(id);
    }

    @Override
    public Integer countByProjectIdAndStatus(Integer id, Integer functionStatus) {
        return this.projectFunctionDao.countByProjectIdAndStatus(id,functionStatus);
    }

    @Override
    public Integer countDelByProjectId(Integer id) {
        return this.projectFunctionDao.countDelByProjectId(id);
    }

    @Override
    public List<ProjectFunction> getProjectPlanFunctionsPage(Integer projectsId, Integer offset, Integer pageSize) {
        return this.projectFunctionDao.getProjectPlanFunctionsPage(projectsId,offset,pageSize);
    }

    @Override
    public List<ProjectFunction> getFunctionByProjectIdAndRealizeUserId(Integer projectsId, Integer realizeUserId, Integer functionStatus) {
        return projectFunctionDao.getAllFunctionByProjectIdAndRealizeUserId(projectsId, realizeUserId, functionStatus);
    }
}