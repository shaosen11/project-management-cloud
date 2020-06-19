package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectMessage)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:16:50
 */
@Mapper
@Repository
public interface ProjectMessageDao extends BaseDao<ProjectMessage>{

    /**
     * 通过projectId和userId查询所有消息
     *
     * @param userId
     * @return
     */
    List<ProjectMessage> getByProjectIdAndUserId(
            @Param("projectId") Integer projectId,
            @Param("userId") Integer userId,
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize);


    /**
     * 通过projectId查询所有项目消息
     *
     * @param projectId
     * @param offset
     * @param pageSize
     * @return
     */
    List<ProjectMessage> getByProjectId(
            @Param("projectId") Integer projectId,
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize);


    /**
     * 修改项目已读
     * @param projectMessageId
     * @return
     */
    boolean updateProjectMessageIsReadByProjectMessageId(Integer projectMessageId);

    /**
     * 通过projectId查询所有待办消息
     *
     * @param projectId
     * @param offset
     * @param pageSize
     * @return
     */
    List<ProjectMessage> getAllNeedToByProjectId(
            @Param("projectId") Integer projectId,
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize);

    /**
     * 通过id查找项目消息
     * @param id
     * @return
     */
    ProjectMessage getById(@Param("id") Integer id);

    /**
     * 获取项目消息数量
     *
     * @param projectId
     * @param userId
     * @return
     */
    Integer getProjectMessageCount(
            @Param("projectId") Integer projectId,
            @Param("userId") Integer userId);

    /**
     * 获取项目消息数量
     *
     * @param projectId
     * @return
     */
    Integer getProjectMessageNeedToDoCount(@Param("projectId") Integer projectId);

}