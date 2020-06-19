package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectUserCooperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectUserCooperation)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:17:51
 */
@Mapper
@Repository
public interface ProjectUserCooperationDao extends BaseDao<ProjectUserCooperation>{

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