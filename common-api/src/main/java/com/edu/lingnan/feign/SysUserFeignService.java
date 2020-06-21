package com.edu.lingnan.feign;

import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.entity.Myprojects;
import com.edu.lingnan.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    SysUser queryById(@RequestParam("id") Integer id);

    @GetMapping("/sysUser/{id}")
    SysUser getSysUser(@RequestParam("id") Integer id);

    @GetMapping("/sysUser/getUserCount")
    Integer getUserCount();

    /**
     * 查询user的信息和项目
     *
     * @param userId
     * @return
     */
    @GetMapping("/sysUser/getMyUserDetailsByUserId/{userId}")
    MyUserDetails getMyUserDetailsByUserId(@RequestParam("userId") Integer userId);

    /**
     * 查询简要的用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/sysUser/getSimpleMyUserDetailsByUserId/{userId}")
    MyUserDetails getSimpleMyUserDetailsByUserId(@RequestParam("userId") Integer userId);

    /**
     * 查询我的所有项目(user)
     *
     * @return
     */
    @GetMapping("/sysUser/getMyProjectsByUserId/{userId}")
    List<Myprojects> getMyProjectsByUserId(@RequestParam("userId") Integer userId);

}