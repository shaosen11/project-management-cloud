package com.edu.lingnan.service;

import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.entity.Myprojects;
import com.edu.lingnan.entity.SysRoleMenu;
import com.edu.lingnan.entity.SysUser;
import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:16:19
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);
    SysUser getById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    boolean insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    boolean update(SysUser sysUser);

    /**
     * 前端异步请求注册邮箱是否存在
     * @param email
     * @return
     */
    MyUserDetails findByEmail(String email);

    /**
     * 注册用户
     * @param myUserDetails
     * @return
     */
    boolean addUser(MyUserDetails myUserDetails);

    /**
     * 更新用户信息
     * @param myUserDetails
     * @return
     */
    MyUserDetails updateUser(MyUserDetails myUserDetails);

    /**
     * 通过id查询是否存在
     * @return
     */
    MyUserDetails findById(Integer id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<MyUserDetails> getUserList();

    /**
     * 添加用户2
     * @param myUserDetails
     * @return
     */
    boolean addUser2(MyUserDetails myUserDetails);

    /**
     * 删除用户
     * @return
     */
    boolean deleteUser(Integer id);

    /**
     * 修改用户信息
     * @return
     */
    boolean editUser(MyUserDetails myUserDetails);

    /**
     * 还原用户
     * @return
     */
    boolean reductionUser(Integer id);

    /**
     * 查询所有已注销用户信息
     * @return
     */
    List<MyUserDetails> getDeletedUserList();

    /**
     * 查询我的项目
     * @return
     */
    List<Myprojects> getMyProjectsByUserId(Integer userId);

    /**
     * 分页--查询我的所有项目(user)
     * @return
     */
    List<Myprojects> getMyProjectsPage(Integer userId,Integer offset,Integer pageSize);


    /**
     * 查询我负责的项目(user)
     * @return
     */
    List<Myprojects> getMyChargeProjects(Integer id);

    /**
     * 分页--查询我负责的项目
     * @return
     */
    List<Myprojects> getMyChargeProjectsPage(Integer userId,Integer offset,Integer pageSize);


    /**
     * 查询我参与的项目(user)
     * @return
     */
    List<Myprojects> getMyJoinProjects(Integer id);

    /**
     * 分页--查询我参与的项目
     * @return
     */
    List<Myprojects> getMyJoinProjectsPage(Integer userId,Integer offset,Integer pageSize);

    /**
     * 查询我所有的项目进度数量(饼图)
     * @return
     */
    Integer myProjectScheduleNum(Integer id,String schedule);

    /**
     * 查询我负责的项目进度数量(饼图1)
     * @return
     */
    Integer myProjectScheduleNum2(Integer id,String schedule);

    /**
     * 查询我参加的项目进度数量(饼图1)
     * @return
     */
    Integer myProjectScheduleNum3(Integer id,String schedule);

    /**
     * 查询我的项目收藏(user)
     * @return
     */
    List<Myprojects> getMyProjectsStore(Integer id);

    /**
     * 分页--查询我的项目收藏(
     * @return
     */
    List<Myprojects> getMyProjectsStorePage(Integer userId, Integer offset, Integer pageSize);


    /**
     * 查询user的信息和项目
     * @param userId
     * @return
     */
    MyUserDetails getMyUserDetailsByUserId(Integer userId);

    /**
     * 查询简要的用户信息
     * @param userId
     * @return
     */
    MyUserDetails getSimpleMyUserDetailsByUserId(Integer userId);

    /**
     * 统计用户数量
     * @return
     */
    Integer userCount();

    SysUser login(String email, String password);

    /**
     * 查询我的所有项目--按类型
     * @return
     */
    Integer getMyProjectsByType(Integer id,String type);

    /**
     * 分页--查询我的所有项目--按类型
     * @return
     */
    List<Myprojects> getMyProjectsPageByType(Integer userId,String type,Integer offset,Integer pageSize);

    /**
     * 查询我的所有项目--按项目名或负责人模糊搜索
     * @return
     */
    Integer getMyProjectsByNameOrUser(Integer id,String nameOrUser);

    /**
     * 分页--查询我的所有项目--按项目名或负责人模糊搜索
     * @return
     */
    List<Myprojects> getMyProjectsPageByNameOrUser(Integer userId,String nameOrUser,Integer offset,Integer pageSize);

    /**
     * 查询我的所有项目--按进度
     * @return
     */
    Integer getMyProjectsBySchedule(Integer id,String schedule);

    /**
     * 分页--查询我的所有项目--按进度
     * @return
     */
    List<Myprojects> getMyProjectsPageBySchedule(Integer userId,String schedule,Integer offset,Integer pageSize);

    /**
     * 查询我的所有项目--按类型和进度
     * @return
     */
    Integer getMyProjectsByTypeSchedule(Integer id,String type,String schedule);

    /**
     * 分页--查询我的所有项目--按类型和进度
     * @return
     */
    List<Myprojects> getMyProjectsPageByTypeSchedule(Integer userId, String type,String schedule,Integer offset,Integer pageSize);

    /**
     * 查询我负责的项目--按类型
     * @return
     */
    Integer getMyProjectsChargeByType(Integer id,String type);

    /**
     * 分页--查询我负责的项目--按类型
     * @return
     */
    List<Myprojects> getMyProjectsChargePageByType(Integer userId,String type,Integer offset,Integer pageSize);

    /**
     * 查询我负责的项目--按项目名或负责人模糊搜索
     * @return
     */
    Integer getMyProjectsChargeByNameOrUser(Integer id,String nameOrUser);

    /**
     * 分页--查询我负责的项目--按项目名或负责人模糊搜索
     * @return
     */
    List<Myprojects> getMyProjectsChargePageByNameOrUser(Integer userId,String nameOrUser,Integer offset,Integer pageSize);

    /**
     * 查询我负责的项目--按进度
     * @return
     */
    Integer getMyProjectsChargeBySchedule(Integer id,String schedule);

    /**
     * 分页--查询我负责的项目--按进度
     * @return
     */
    List<Myprojects> getMyProjectsChargePageBySchedule(Integer userId,String schedule,Integer offset,Integer pageSize);

    /**
     * 查询我负责的项目--按类型和进度
     * @return
     */
    Integer getMyProjectsChargeByTypeSchedule(Integer id,String type,String schedule);

    /**
     * 分页--查询我负责的项目--按类型和进度
     * @return
     */
    List<Myprojects> getMyProjectsChargePageByTypeSchedule(Integer userId,String type,String schedule,Integer offset,Integer pageSize);

    /**
     * 查询我参加的项目--按类型
     * @return
     */
    Integer getMyProjectsJoinByType(Integer id,String type);

    /**
     * 分页--查询我参加的项目--按类型
     * @return
     */
    List<Myprojects> getMyProjectsJoinPageByType(Integer userId,String type,Integer offset,Integer pageSize);

    /**
     * 查询我参加的项目--按项目名或负责人模糊搜索
     * @return
     */
    Integer getMyProjectsJoinByNameOrUser(Integer id,String nameOrUser);

    /**
     * 分页--查询我参加的项目--按项目名或负责人模糊搜索
     * @return
     */
    List<Myprojects> getMyProjectsJoinPageByNameOrUser(Integer userId,String nameOrUser,Integer offset,Integer pageSize);

    /**
     * 查询我参加的项目--按进度
     * @return
     */
    Integer getMyProjectsJoinBySchedule(Integer id,String schedule);

    /**
     * 分页--查询我参加的项目--按进度
     * @return
     */
    List<Myprojects> getMyProjectsJoinPageBySchedule(Integer userId, String schedule, Integer offset, Integer pageSize);

    /**
     * 查询我参加的项目--按类型和进度
     * @return
     */
    Integer getMyProjectsJoinByTypeSchedule(Integer id,String type,String schedule);

    /**
     * 分页--查询我参加的项目--按类型和进度
     * @return
     */
    List<Myprojects> getMyProjectsJoinPageByTypeSchedule(Integer userId,String type,String schedule,Integer offset,Integer pageSize);
}