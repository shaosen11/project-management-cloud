package com.edu.lingnan.dao;

import com.edu.lingnan.entity.UserClick;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (UserClick)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:18:31
 */
@Mapper
@Repository
public interface UserClickDao extends BaseDao<UserClick>{

    /**
     * 查询一条点击记录
     * @return
     */
    UserClick getUserClickByUserIdAndProjectId(@Param("userId") Integer userId, @Param("projectId") Integer projectId);


    /**
     * 删除点击记录
     * @return
     */
    boolean deleteUserClick(@Param("userId") Integer userId, @Param("projectId") Integer projectId);

    /**
     * 还原点击记录
     * @return
     */
    boolean reductionUserClick(@Param("userId") Integer userId, @Param("projectId") Integer projectId);

    /**
     * 查询项目点击次数
     * @return
     */
    Integer getCountProjectByClick(Integer id);
}