package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectUserDuty;
import com.edu.lingnan.dao.ProjectUserDutyDao;
import com.edu.lingnan.feign.ProjectUserDutyFeignService;
import com.edu.lingnan.service.ProjectUserDutyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectUserDuty)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:59
 */
@Service("projectUserDutyService")
public class ProjectUserDutyServiceImpl implements ProjectUserDutyService {
    @Resource
    private ProjectUserDutyDao projectUserDutyDao;


    @Override
    public ProjectUserDuty getById(Integer id) {
        return projectUserDutyDao.getById(id);
    }
}