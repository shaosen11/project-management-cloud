package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectUser;
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
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectUser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectUser 实例对象
     * @return 对象列表
     */
    List<ProjectUser> queryAll(ProjectUser projectUser);

    /**
     * 删除项目用户信息通过项目id
     * @param id 项目id
     * @return boolean
     */
    Integer deleteProjectUserByProjectsId(Integer id);

    /**
     * 通过用户Id和项目Id查询用户
     * @return ProjectUser
     */
    ProjectUser getByUserIdAndProjectId(@Param("userId")Integer userId, @Param("projectId")Integer projectId);


}