package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.entity.Myprojects;
import com.edu.lingnan.entity.SysRoleMenu;
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
    public SysUser getById(Integer id) {
        return sysUserDao.getById(id);
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
    public MyUserDetails findByEmail(String email) {
        return null;
    }

    @Override
    public boolean addUser(MyUserDetails myUserDetails) {
        return false;
    }

    @Override
    public MyUserDetails updateUser(MyUserDetails myUserDetails) {
        return null;
    }

    @Override
    public MyUserDetails findById(Integer id) {
        return null;
    }

    @Override
    public List<MyUserDetails> getUserList() {
        return null;
    }

    @Override
    public boolean addUser2(MyUserDetails myUserDetails) {
        return false;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }

    @Override
    public boolean editUser(MyUserDetails myUserDetails) {
        return false;
    }

    @Override
    public boolean reductionUser(Integer id) {
        return false;
    }

    @Override
    public List<MyUserDetails> getDeletedUserList() {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsByUserId(Integer userId) {
        return sysUserDao.getMyProjectsByUserId(userId);
    }

    @Override
    public List<Myprojects> getMyProjectsPage(Integer userId, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public List<Myprojects> getMyChargeProjects(Integer id) {
        return null;
    }

    @Override
    public List<Myprojects> getMyChargeProjectsPage(Integer userId, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public List<Myprojects> getMyJoinProjects(Integer id) {
        return null;
    }

    @Override
    public List<Myprojects> getMyJoinProjectsPage(Integer userId, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer myProjectScheduleNum(Integer id, String schedule) {
        return null;
    }

    @Override
    public Integer myProjectScheduleNum2(Integer id, String schedule) {
        return null;
    }

    @Override
    public Integer myProjectScheduleNum3(Integer id, String schedule) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsStore(Integer id) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsStorePage(Integer userId, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public MyUserDetails getMyUserDetailsByUserId(Integer userId) {
        return sysUserDao.getMyUserDetailsByUserId(userId);
    }

    @Override
    public MyUserDetails getSimpleMyUserDetailsByUserId(Integer userId) {
        return sysUserDao.getSimpleMyUserDetailsByUserId(userId);
    }

    @Override
    public Integer userCount() {
        return sysUserDao.userCount();
    }

    @Override
    public SysUser login(String email, String password) {
        return null;
    }

    @Override
    public Integer getMyProjectsByType(Integer id, String type) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsPageByType(Integer userId, String type, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getMyProjectsByNameOrUser(Integer id, String nameOrUser) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsPageByNameOrUser(Integer userId, String nameOrUser, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getMyProjectsBySchedule(Integer id, String schedule) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsPageBySchedule(Integer userId, String schedule, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getMyProjectsByTypeSchedule(Integer id, String type, String schedule) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsPageByTypeSchedule(Integer userId, String type, String schedule, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getMyProjectsChargeByType(Integer id, String type) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsChargePageByType(Integer userId, String type, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getMyProjectsChargeByNameOrUser(Integer id, String nameOrUser) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsChargePageByNameOrUser(Integer userId, String nameOrUser, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getMyProjectsChargeBySchedule(Integer id, String schedule) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsChargePageBySchedule(Integer userId, String schedule, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getMyProjectsChargeByTypeSchedule(Integer id, String type, String schedule) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsChargePageByTypeSchedule(Integer userId, String type, String schedule, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getMyProjectsJoinByType(Integer id, String type) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsJoinPageByType(Integer userId, String type, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getMyProjectsJoinByNameOrUser(Integer id, String nameOrUser) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsJoinPageByNameOrUser(Integer userId, String nameOrUser, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getMyProjectsJoinBySchedule(Integer id, String schedule) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsJoinPageBySchedule(Integer userId, String schedule, Integer offset, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getMyProjectsJoinByTypeSchedule(Integer id, String type, String schedule) {
        return null;
    }

    @Override
    public List<Myprojects> getMyProjectsJoinPageByTypeSchedule(Integer userId, String type, String schedule, Integer offset, Integer pageSize) {
        return null;
    }

}