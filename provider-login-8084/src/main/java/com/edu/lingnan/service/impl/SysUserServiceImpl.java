package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.service.SysUserService;
import com.edu.lingnan.dao.SysUserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-16 10:59:06
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(SysUser sysUser) {
        return true;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(SysUser sysUser) {
//        this.sysUserDao.update(sysUser);
//        return this.queryById(sysUser.getId());
        return true;
    }

    @Override
    public SysUser login(String email, String password) {
        return sysUserDao.login(email, password);
    }


}