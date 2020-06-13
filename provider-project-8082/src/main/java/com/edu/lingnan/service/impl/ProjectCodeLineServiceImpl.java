package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectCodeLine;
import com.edu.lingnan.dao.ProjectCodeLineDao;
import com.edu.lingnan.feign.ProjectCodeLineFeignService;
import com.edu.lingnan.service.ProjectCodeLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectCodeLine)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:16:33
 */
@Service("projectCodeLineService")
public class ProjectCodeLineServiceImpl implements ProjectCodeLineService {
    @Resource
    private ProjectCodeLineDao projectCodeLineDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProjectCodeLine queryById(Integer id) {
        return this.projectCodeLineDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProjectCodeLine> queryAllByLimit(int offset, int limit) {
        return this.projectCodeLineDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param projectCodeLine 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectCodeLine insert(ProjectCodeLine projectCodeLine) {
        this.projectCodeLineDao.insert(projectCodeLine);
        return projectCodeLine;
    }

    /**
     * 修改数据
     *
     * @param projectCodeLine 实例对象
     * @return 实例对象
     */
    @Override
    public ProjectCodeLine update(ProjectCodeLine projectCodeLine) {
        this.projectCodeLineDao.update(projectCodeLine);
        return this.queryById(projectCodeLine.getId());
    }

}