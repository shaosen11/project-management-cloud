package com.edu.lingnan.service;

import com.edu.lingnan.entity.UserStore;
import java.util.List;

/**
 * (UserStore)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:17:02
 */
public interface UserStoreService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserStore queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserStore> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userStore 实例对象
     * @return 实例对象
     */
    Boolean insert(UserStore userStore);

    /**
     * 修改数据
     *
     * @param userStore 实例对象
     * @return 实例对象
     */
    UserStore update(UserStore userStore);

    /**
     * 查询项目被收藏数
     * @return
     */
    Integer countStoredNumByProjectId(Integer projectId);

    /**
     * 删除收藏记录
     * @return boolean
     */
    boolean deleteUserStore(Integer userId,Integer projectId);


}