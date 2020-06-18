package com.edu.lingnan.service.impl;

import com.edu.lingnan.dao.MyUserDetailsDao;
import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
    @Autowired
    private MyUserDetailsDao myUserDetailsDao;

    @Override
    public MyUserDetails findByEmail(String email) {
        return myUserDetailsDao.findByEmail(email);
    }

    @Override
    public List<String> findRoleByEmail(String email) {
        return myUserDetailsDao.findRoleByEmail(email);
    }

    @Override
    public List<String> findAuthorityByRoleCodes(List<String> roleCodes) {
        return myUserDetailsDao.findAuthorityByRoleCodes(roleCodes);
    }

    @Override
    public List<String> findAuthorityByEmail(String email) {
        List<String> roleCodes = myUserDetailsDao.findRoleByEmail(email);
        return myUserDetailsDao.findAuthorityByRoleCodes(roleCodes);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //加载基础用户信息
        MyUserDetails myUserDetails = myUserDetailsDao.findByEmail(email);
        //加载用户角色列表
        List<String> roleCodes = myUserDetailsDao.findRoleByEmail(email);
        //通过用户角色列表加载用户的资源权限
        List<String> authoritys = myUserDetailsDao.findAuthorityByRoleCodes(roleCodes);
        //角色是一个特殊的权限，ROLE_前缀
        roleCodes = roleCodes.stream()
                .map(rc -> "ROLE_" + rc)
                .collect(Collectors.toList());

        authoritys.addAll(roleCodes);

        myUserDetails.setAuthorities(
                AuthorityUtils.commaSeparatedStringToAuthorityList(
                        String.join(",", authoritys)
                )
        );
        return myUserDetails;
    }
}
