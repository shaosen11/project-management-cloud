package com.edu.lingnan.fegin;

import com.edu.lingnan.entity.MyUserDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:14:41
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface MyUserDetailsFeignService {
    @PostMapping("/MyUserDetails/findByEmail")
    MyUserDetails findByEmail(@RequestParam("email") String email);

    @PostMapping("/MyUserDetails/findRoleByEmail")
    List<String> findRoleByEmail(@RequestParam("email") String email);

    @PostMapping("/MyUserDetails/findAuthorityByEmail")
    List<String> findAuthorityByEmail(@RequestParam("email") String email);

    @PostMapping("/MyUserDetails/loadUserByUsername")
    MyUserDetails loadUserByUsername(@RequestParam("email") String email);


}