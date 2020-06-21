package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectUserCooperation;
import com.edu.lingnan.dao.ProjectUserCooperationDao;
import com.edu.lingnan.feign.ProjectUserCooperationFeignService;
import com.edu.lingnan.service.ProjectUserCooperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectUserCooperation)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:51
 */
@Service("projectUserCooperationService")
public class ProjectUserCooperationServiceImpl implements ProjectUserCooperationService {
    @Resource
    private ProjectUserCooperationDao projectUserCooperationDao;

    @Override
    public ProjectUserCooperation getByProjectIdAndInProjectUserIdAndNotInProjectUserIdAndInviteAndFinish(Integer projectId, Integer inProjectUserId, Integer notInProjectUserId, Integer inviteFlag, Integer finishFlag) {
        return projectUserCooperationDao.getByProjectIdAndInProjectUserIdAndNotInProjectUserIdAndInviteAndFinish(projectId, inProjectUserId, notInProjectUserId, inviteFlag, finishFlag);
    }

    @Override
    public boolean insert(ProjectUserCooperation projectsUserCooperation) {
        return projectUserCooperationDao.insert(projectsUserCooperation) > 0;
    }

    @Override
    public boolean update(ProjectUserCooperation projectsUserCooperation) {
        return projectUserCooperationDao.update(projectsUserCooperation);
    }

    @Override
    public ProjectUserCooperation getById(Integer id) {
        return projectUserCooperationDao.getById(id);
    }

    @Override
    public List<ProjectUserCooperation> getByProjectIdAndNotInProjectUserIdAndInviteAndFinish(Integer projectId, Integer notInProjectUserId, Integer invite, Integer finish) {
        return projectUserCooperationDao.getByProjectIdAndNotInProjectUserIdAndInviteAndFinish(projectId, notInProjectUserId, invite, finish);
    }

}