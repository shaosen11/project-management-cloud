package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.UserStore;
import com.edu.lingnan.dao.UserStoreDao;
import com.edu.lingnan.feign.UserStoreFeignService;
import com.edu.lingnan.service.UserStoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserStore)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:19:11
 */
@Service("userStoreService")
public class UserStoreServiceImpl implements UserStoreService {
    @Resource
    private UserStoreDao userStoreDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserStore queryById(Integer id) {
        return this.userStoreDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserStore> queryAllByLimit(int offset, int limit) {
        return this.userStoreDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userStore 实例对象
     * @return 实例对象
     */
    @Override
    public UserStore insert(UserStore userStore) {
        this.userStoreDao.insert(userStore);
        return userStore;
    }

    /**
     * 修改数据
     *
     * @param userStore 实例对象
     * @return 实例对象
     */
    @Override
    public UserStore update(UserStore userStore) {
        this.userStoreDao.update(userStore);
        return this.queryById(userStore.getId());
    }

}