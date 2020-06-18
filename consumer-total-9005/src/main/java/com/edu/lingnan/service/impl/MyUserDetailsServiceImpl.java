package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.fegin.MyUserDetailsFeignService;
import com.edu.lingnan.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author shaosen
 */
@Service
@CacheConfig(cacheNames = "userDetails")
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
    @Autowired
    private MyUserDetailsFeignService myUserDetailsFeignService;

    @Override
    public MyUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //加载基础用户信息
        MyUserDetails myUserDetails = myUserDetailsFeignService.findByEmail(email);
        //加载用户角色列表
        List<String> roleCodes = myUserDetailsFeignService.findRoleByEmail(email);
        //通过用户角色列表加载用户的资源权限
        List<String> authoritys = myUserDetailsFeignService.findAuthorityByEmail(email);
        //角色是一个特殊的权限，ROLE_前缀
        roleCodes = roleCodes.stream()
                .map(rc -> "ROLE_" + rc)
                .collect(Collectors.toList());

        authoritys.addAll(roleCodes);

        myUserDetails.setAuthorities(
                AuthorityUtils.commaSeparatedStringToAuthorityList(
                        String.join(",",authoritys)
                )
        );
        return myUserDetails;
    }
}
