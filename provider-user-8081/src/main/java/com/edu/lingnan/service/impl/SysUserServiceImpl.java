package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.dao.SysUserDao;
import com.edu.lingnan.feign.SysUserFeignService;
import com.edu.lingnan.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 20:52:17
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    @Override
    public SysUser queryById(Integer id) {
        return this.sysUserDao.queryById(id);
    }

    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    @Override
    public boolean insert(SysUser sysUser) {
        return sysUserDao.insert(sysUser) > 0;
    }

    @Override
    public boolean update(SysUser sysUser) {
        return sysUserDao.update(sysUser);
    }

    @Override
    public Integer userCount() {
        return sysUserDao.userCount();
    }

}