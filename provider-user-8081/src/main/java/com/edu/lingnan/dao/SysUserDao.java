package com.edu.lingnan.dao;

import com.edu.lingnan.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 20:52:15
 */
@Mapper
@Repository
public interface SysUserDao extends BaseDao<SysUser>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(@Param("id") Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    List<SysUser> queryAll(SysUser sysUser);


    /**
     * 统计用户数量
     * @return
     */
    Integer userCount();

    ProjectSchedule getProjectScheduleById(@Param("id") Integer id);

    ProjectType getProjectTypeById(@Param("id") Integer id);

    /**
     * 查询我的所有项目(user)
     *
     * @return
     */
    List<Myprojects> getMyProjects(@Param("id") Integer id);

    /**
     * 查询user的信息和项目
     *
     * @param userId
     * @return
     */
    MyUserDetails getMyUserDetailsByUserId(@Param("userId") Integer userId);

    /**
     * 查询简要的用户信息
     *
     * @param id
     * @return
     */
    MyUserDetails getSimpleMyUserDetailsByUserId(@Param("id") Integer id);
}