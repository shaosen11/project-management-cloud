package com.edu.lingnan.service;

import com.edu.lingnan.entity.UserClick;
import java.util.List;

/**
 * (UserClick)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:16:31
 */
public interface UserClickService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserClick queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserClick> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userClick 实例对象
     * @return 实例对象
     */
    UserClick insert(UserClick userClick);

    /**
     * 修改数据
     *
     * @param userClick 实例对象
     * @return 实例对象
     */
    UserClick update(UserClick userClick);


}