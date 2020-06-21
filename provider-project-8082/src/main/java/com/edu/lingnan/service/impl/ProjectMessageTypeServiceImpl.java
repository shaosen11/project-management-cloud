package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectMessageType;
import com.edu.lingnan.dao.ProjectMessageTypeDao;
import com.edu.lingnan.feign.ProjectMessageTypeFeignService;
import com.edu.lingnan.service.ProjectMessageTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectMessageType)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:07
 */
@Service("projectMessageTypeService")
public class ProjectMessageTypeServiceImpl implements ProjectMessageTypeService {
    @Resource
    private ProjectMessageTypeDao projectMessageTypeDao;


    @Override
    public ProjectMessageType getById(Integer id) {
        return projectMessageTypeDao.getById(id);
    }
}