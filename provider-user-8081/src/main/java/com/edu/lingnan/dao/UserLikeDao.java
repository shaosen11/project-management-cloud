package com.edu.lingnan.dao;

import com.edu.lingnan.entity.UserLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (UserLike)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:18:50
 */
@Mapper
@Repository
public interface UserLikeDao extends BaseDao<UserLike>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserLike queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserLike> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userLike 实例对象
     * @return 对象列表
     */
    List<UserLike> queryAll(UserLike userLike);

    /**
     * 查询项目被点赞数
     * @return Integer
     */
    Integer countLikedNumByProjectId(Integer projectId);

    /**
     * 删除点赞记录
     * @return
     */
    boolean deleteUserLike(@Param("userId")Integer userId, @Param("projectId")Integer projectId);


}