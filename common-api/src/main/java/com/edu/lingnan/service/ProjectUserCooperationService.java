package com.edu.lingnan.service;


import com.edu.lingnan.entity.ProjectUserCooperation;

import java.util.List;

/**
 * (ProjectUserCooperation)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:18:31
 */
public interface ProjectUserCooperationService {

    /**
     * 查找项目有没有邀请过此人，并且未完成邀请
     *
     * @param projectId
     * @param inProjectUserId
     * @param notInProjectUserId
     * @param inviteFlag
     * @param finishFlag
     * @return
     */
    ProjectUserCooperation getByProjectIdAndInProjectUserIdAndNotInProjectUserIdAndInviteAndFinish(Integer projectId, Integer inProjectUserId, Integer notInProjectUserId, Integer inviteFlag, Integer finishFlag);

    /**
     * 插入一条邀请记录
     *
     * @param projectsUserCooperation
     * @return
     */
    boolean insert(ProjectUserCooperation projectsUserCooperation);

    /**
     * 修改状态
     *
     * @param projectsUserCooperation
     * @return
     */
    boolean update(ProjectUserCooperation projectsUserCooperation);

    /**
     * 通过id查找
     *
     * @param id
     * @return
     */
    ProjectUserCooperation getById(Integer id);

    /**
     * 获取项目对个人的所有邀请
     *
     * @param projectId
     * @param notInProjectUserId
     * @param inviteFlag
     * @param finishFlag
     * @return
     */
    List<ProjectUserCooperation> getByProjectIdAndNotInProjectUserIdAndInviteAndFinish(Integer projectId, Integer notInProjectUserId, Integer inviteFlag, Integer finishFlag);


}