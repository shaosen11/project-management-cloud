package com.edu.lingnan.service;

import com.edu.lingnan.entity.UserLike;
import java.util.List;

/**
 * (UserLike)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:16:43
 */
public interface UserLikeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserLike queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserLike> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userLike 实例对象
     * @return 实例对象
     */
    UserLike insert(UserLike userLike);

    /**
     * 修改数据
     *
     * @param userLike 实例对象
     * @return 实例对象
     */
    UserLike update(UserLike userLike);


}