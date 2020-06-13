package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectMessage;
import com.edu.lingnan.dao.ProjectMessageDao;
import com.edu.lingnan.feign.ProjectMessageFeignService;
import com.edu.lingnan.service.ProjectMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectMessage)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:16:50
 */
@Service("projectMessageService")
public class ProjectMessageServiceImpl implements ProjectMessageService {
    @Resource
    private ProjectMessageDao projectMessageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectMessage queryById(Integer id) {
        return this.projectMessageDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectMessage> queryAllByLimit(int offset, int limit) {
        return this.projectMessageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectMessage 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectMessage insert(ProjectMessage projectMessage) {
        this.projectMessageDao.insert(projectMessage);
        return projectMessage;
    }

    /**
     * 修改数据
     *
     * @param projectMessage 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectMessage update(ProjectMessage projectMessage) {
        this.projectMessageDao.update(projectMessage);
        return this.queryById(projectMessage.getId());
    }

}