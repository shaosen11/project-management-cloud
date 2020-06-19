package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectMessage;
import java.util.List;

/**
 * (ProjectMessage)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:17:47
 */
public interface ProjectMessageService {

    /**
     * 通过projectId和userId查询所有个人消息
     *
     * @param projectId
     * @param userId
     * @param offset
     * @param pageSize
     * @return
     */
    List<ProjectMessage> getByProjectIdAndUserId(Integer projectId, Integer userId, Integer offset, Integer pageSize);

    /**
     * 插入一条项目信息
     *
     * @param projectsMessage
     */
    boolean insert(ProjectMessage projectsMessage);

    /**
     * 通过projectId查询所有项目消息
     *
     * @param projectId
     * @param offset
     * @param pageSize
     * @return
     */
    List<ProjectMessage> getByProjectId(Integer projectId, Integer offset, Integer pageSize);

    /**
     * 修改项目消息
     *
     * @param projectsMessage
     * @return
     */
    boolean update(ProjectMessage projectsMessage);

    /**
     * 修改项目消息已读
     *
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
    List<ProjectMessage> getAllNeedToByProjectId(Integer projectId, Integer offset, Integer pageSize);

    /**
     * 通过id查找项目消息
     *
     * @param id
     * @return
     */
    ProjectMessage getById(Integer id);

    /**
     * 获取项目消息数量
     *
     * @param projectId
     * @param userId
     * @return
     */
    Integer getProjectMessageCount(Integer projectId, Integer userId);

    /**
     * 获取项目消息数量
     *
     * @param projectId
     * @return
     */
    Integer getProjectMessageNeedToDoCount(Integer projectId);


}