package com.edu.lingnan.dao;

import com.edu.lingnan.entity.Echarts;
import com.edu.lingnan.entity.ProjectUser;
import com.edu.lingnan.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:17:45
 */
@Mapper
@Repository
public interface ProjectUserDao extends BaseDao<ProjectUser>{

    /**
     * 查询所有项目用户信息
     * @return
     */
    List<ProjectUser> getProjectUserList();

    /**
     * 删除项目用户信息
     * @return
     */
    boolean delete(Integer id);

    /**
     * 删除项目用户信息通过项目id
     * @return
     */
    Integer deleteProjectUserByProjectsId(Integer projectsId);

    /**
     * 还原项目用户信息
     * @return
     */
    boolean reductionProjectUser(Integer id);

    /**
     * 查询所有已注销项目用户信息
     * @return
     */
    List<ProjectUser> getDelProjectUserList();

    /**
     * 通过用户Id和项目Id查询用户
     * @param userId
     * @param projectId
     * @return
     */
    ProjectUser getByUserIdAndProjectId(Integer userId, Integer projectId);

    /**
     * 通过Id查询
     * @return
     */
    ProjectUser getById(Integer id);

    /**
     * 通过Id查询已注销的记录
     * @return
     */
    ProjectUser getDelById(Integer id);

    /**
     * 获取代码贡献量
     * @param projectId
     * @return
     */
    List<Echarts> getCodeDevote(Integer projectId);

    /**
     * 获取代码上传次数
     * @param projectId
     * @return
     */
    List<Echarts> getCodeInsert(Integer projectId);

    /**
     * 查询项目总共人数
     * @param projectId
     * @return
     */
    Integer getCountByProjectId(Integer projectId);

    /**
     * 通过项目id查找所有项目成员
     * @param projectId
     * @return
     */
    List<ProjectUser> getPageProjectUserByProjectId(Integer projectId, Integer offset, Integer pageSize);

    /**
     * 通过项目id查找所有项目成员
     *
     * @param projectId
     * @return
     */
    List<ProjectUser> getAllProjectUserByProjectId(Integer projectId);


    /**
     * 查询项目总共人数
     * @param projectId
     * @return
     */
    Integer getCountNoInProjectByProjectId(Integer projectId);

    /**
     * 通过项目id查找不在项目的成员
     * @param projectId
     * @return
     */
    List<SysUser> getProjectUserNoInProjectByProjectId(Integer projectId, Integer offset, Integer pageSize);

    /**
     * 通过userId查询
     * @return
     */
    List<ProjectUser> getAllProjectByUserId(Integer userId);

    /**
     * 获取项目各类人数
     * @param projectId
     * @param dutyCode
     * @return
     */
    Integer getCountByProjectIdAndDuty(Integer projectId, Integer dutyCode);



}