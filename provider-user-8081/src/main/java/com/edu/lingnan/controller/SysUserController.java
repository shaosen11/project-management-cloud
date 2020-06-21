package com.edu.lingnan.controller;

import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.entity.Myprojects;
import com.edu.lingnan.entity.SysUser;
import com.edu.lingnan.feign.SysUserFeignService;
import com.edu.lingnan.service.MyUserDetailsService;
import com.edu.lingnan.service.SysUserService;
import com.edu.lingnan.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2020-06-11 20:52:18
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    /**
     * 增
     * @param sysUser
     * @return
     */
    @PostMapping("/")
    public boolean addSysUser(SysUser sysUser) {
        return sysUserService.insert(sysUser);
    }

    /**
     * 查
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public SysUser getSysUser(@PathVariable("id") Integer id) {
    @GetMapping("queryById/{id}")
    public SysUser queryById(@PathVariable("id") Integer id) {
        return this.sysUserService.queryById(id);
    }

    /**
     * 改
     * @param sysUser
     * @return
     */
    @PutMapping("/")
    public boolean updateSysUser(SysUser sysUser){
        return sysUserService.update(sysUser);
    }

    @GetMapping("/getUserCount")
    public Integer userCount(){
        return sysUserService.userCount();
    }

    /**
     * 查询user的信息和项目
     *
     * @param userId
     * @return
     */
    @GetMapping("getMyUserDetailsByUserId/{userId}")
    public MyUserDetails getMyUserDetailsByUserId(@PathVariable("userId") Integer userId) {
        return sysUserService.getMyUserDetailsByUserId(userId);
    }

    /**
     * 查询简要的用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("getSimpleMyUserDetailsByUserId/{userId}")
    public MyUserDetails getSimpleMyUserDetailsByUserId(Integer userId) {
        return sysUserService.getSimpleMyUserDetailsByUserId(userId);
    }

    /**
     * 查询我的所有项目(user)
     *
     * @return
     */
    @GetMapping("getMyProjectsByUserId/{userId}")
    public List<Myprojects> getMyProjectsByUserId(Integer userId){
        return sysUserService.getMyProjectsByUserId(userId);
    }

}