package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectUser;
import com.edu.lingnan.dao.ProjectUserDao;
import com.edu.lingnan.feign.ProjectUserFeignService;
import com.edu.lingnan.service.ProjectUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:45
 */
@Service("projectUserService")
public class ProjectUserServiceImpl implements ProjectUserService {
    @Resource
    private ProjectUserDao projectUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectUser queryById(Integer id) {
        return this.projectUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectUser> queryAllByLimit(int offset, int limit) {
        return this.projectUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectUser 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectUser insert(ProjectUser projectUser) {
        this.projectUserDao.insert(projectUser);
        return projectUser;
    }

    /**
     * 修改数据
     * @param projectUser 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectUser update(ProjectUser projectUser) {
        this.projectUserDao.update(projectUser);
        return this.queryById(projectUser.getId());
    }

    /**
     * 删除项目用户信息通过项目id
     * @param id 项目id
     * @return boolean
     */
    @Override
    public boolean deleteProjectUserByProjectsId(Integer id) {
        return this.projectUserDao.deleteProjectUserByProjectsId(id)>0;
    }

    @Override
    public ProjectUser getByUserIdAndProjectId(Integer userId, Integer projectId) {
        return this.projectUserDao.getByUserIdAndProjectId(userId, projectId);
    }

}