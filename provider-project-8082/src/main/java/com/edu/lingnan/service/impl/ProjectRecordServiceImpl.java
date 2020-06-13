package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectRecord;
import com.edu.lingnan.dao.ProjectRecordDao;
import com.edu.lingnan.feign.ProjectRecordFeignService;
import com.edu.lingnan.service.ProjectRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:22
 */
@Service("projectRecordService")
public class ProjectRecordServiceImpl implements ProjectRecordService {
    @Resource
    private ProjectRecordDao projectRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectRecord queryById(Integer id) {
        return this.projectRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectRecord> queryAllByLimit(int offset, int limit) {
        return this.projectRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectRecord 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectRecord insert(ProjectRecord projectRecord) {
        this.projectRecordDao.insert(projectRecord);
        return projectRecord;
    }

    /**
     * 修改数据
     *
     * @param projectRecord 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectRecord update(ProjectRecord projectRecord) {
        this.projectRecordDao.update(projectRecord);
        return this.queryById(projectRecord.getId());
    }

}