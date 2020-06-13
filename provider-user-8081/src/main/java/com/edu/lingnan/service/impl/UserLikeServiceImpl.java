package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.UserLike;
import com.edu.lingnan.dao.UserLikeDao;
import com.edu.lingnan.feign.UserLikeFeignService;
import com.edu.lingnan.service.UserLikeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserLike)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:18:50
 */
@Service("userLikeService")
public class UserLikeServiceImpl implements UserLikeService {
    @Resource
    private UserLikeDao userLikeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserLike queryById(Integer id) {
        return this.userLikeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserLike> queryAllByLimit(int offset, int limit) {
        return this.userLikeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userLike 实例对象
     * @return 实例对象
     */
    @Override
    public UserLike insert(UserLike userLike) {
        this.userLikeDao.insert(userLike);
        return userLike;
    }

    /**
     * 修改数据
     *
     * @param userLike 实例对象
     * @return 实例对象
     */
    @Override
    public UserLike update(UserLike userLike) {
        this.userLikeDao.update(userLike);
        return this.queryById(userLike.getId());
    }

}