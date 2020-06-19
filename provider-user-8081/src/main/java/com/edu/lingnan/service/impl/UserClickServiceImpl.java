package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.UserClick;
import com.edu.lingnan.dao.UserClickDao;
import com.edu.lingnan.feign.UserClickFeignService;
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
@Service("UserClickService")
public class UserClickServiceImpl implements UserClickService {
    @Resource
    private UserClickDao userClickDao;


    @Override
    public UserClick getUserClickByUserIdAndProjectId(Integer userId, Integer projectId) {
        return userClickDao.getUserClickByUserIdAndProjectId(userId, projectId);
    }


    @Override
    public boolean deleteUserClick(Integer userId, Integer projectId) {
        return userClickDao.deleteUserClick(userId, projectId);
    }

    @Override
    public boolean reductionUserClick(Integer userId, Integer projectId) {
        return userClickDao.reductionUserClick(userId, projectId);
    }

    @Override
    public Integer getCountProjectByClick(Integer id) {
        return userClickDao.getCountProjectByClick(id);
    }

    @Override
    public Boolean insert(UserClick userClick) {
        return userClickDao.insert(userClick) > 0;
    }
}