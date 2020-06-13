package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectMessageNeedToDoRelationship;
import com.edu.lingnan.dao.ProjectMessageNeedToDoRelationshipDao;
import com.edu.lingnan.feign.ProjectMessageNeedToDoRelationshipFeignService;
import com.edu.lingnan.service.ProjectMessageNeedToDoRelationshipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectMessageNeedToDoRelationship)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:16:59
 */
@Service("projectMessageNeedToDoRelationshipService")
public class ProjectMessageNeedToDoRelationshipServiceImpl implements ProjectMessageNeedToDoRelationshipService {
    @Resource
    private ProjectMessageNeedToDoRelationshipDao projectMessageNeedToDoRelationshipDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectMessageNeedToDoRelationship queryById(Integer id) {
        return this.projectMessageNeedToDoRelationshipDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectMessageNeedToDoRelationship> queryAllByLimit(int offset, int limit) {
        return this.projectMessageNeedToDoRelationshipDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectMessageNeedToDoRelationship 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectMessageNeedToDoRelationship insert(ProjectMessageNeedToDoRelationship projectMessageNeedToDoRelationship) {
        this.projectMessageNeedToDoRelationshipDao.insert(projectMessageNeedToDoRelationship);
        return projectMessageNeedToDoRelationship;
    }

    /**
     * 修改数据
     *
     * @param projectMessageNeedToDoRelationship 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectMessageNeedToDoRelationship update(ProjectMessageNeedToDoRelationship projectMessageNeedToDoRelationship) {
        this.projectMessageNeedToDoRelationshipDao.update(projectMessageNeedToDoRelationship);
        return this.queryById(projectMessageNeedToDoRelationship.getId());
    }

}