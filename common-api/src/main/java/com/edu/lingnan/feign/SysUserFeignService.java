package com.edu.lingnan.feign;

import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:14:41
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface SysUserFeignService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping("/sysUser/queryById/{id}")
    SysUser queryById(@PathVariable("id") Integer id);
    @GetMapping("/sysUser/{id}")
    SysUser getSysUser(@PathVariable("id") Integer id);

    @GetMapping("/sysUser/getUserCount")
    Integer getUserCount();

    /**
     * 查询user的信息和项目
     * @param userId
     * @return
     */
    @GetMapping("/sysUser/getMyUserDetailsByUserId/{userId}")
    MyUserDetails getMyUserDetailsByUserId(@PathVariable("userId") Integer userId);

    /**
     * 查询简要的用户信息
     * @param userId
     * @return
     */
    @GetMapping("/sysUser/getSimpleMyUserDetailsByUserId/{userId}")
    MyUserDetails getSimpleMyUserDetailsByUserId(@PathVariable("userId") Integer userId);
}