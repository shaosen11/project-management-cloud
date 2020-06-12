package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.UserClick;
import com.edu.lingnan.dao.UserClickDao;
import com.edu.lingnan.service.UserClickService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserClick)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:18:31
 */
@Service("userClickService")
public class UserClickServiceImpl implements UserClickService {
    @Resource
    private UserClickDao userClickDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserClick queryById(Integer id) {
        return this.userClickDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserClick> queryAllByLimit(int offset, int limit) {
        return this.userClickDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userClick 实例对象
     * @return 实例对象
     */
    @Override
    public UserClick insert(UserClick userClick) {
        this.userClickDao.insert(userClick);
        return userClick;
    }

    /**
     * 修改数据
     *
     * @param userClick 实例对象
     * @return 实例对象
     */
    @Override
    public UserClick update(UserClick userClick) {
        this.userClickDao.update(userClick);
        return this.queryById(userClick.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userClickDao.deleteById(id) > 0;
    }
}