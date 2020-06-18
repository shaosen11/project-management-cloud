package com.edu.lingnan.service;

import com.edu.lingnan.entity.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author shaosen
 */
public interface MyUserDetailsService extends UserDetailsService {
    /**
     * 根据userID查询用户信息
     * @param email
     * @return
     */
    MyUserDetails findByEmail(String email);

    /**
     * 根据userID查询你用户角色
     * @param email
     * @return
     */
    List<String> findRoleByEmail(String email);

    /**
     * 根据用户角色查询用户权限
     * @param roleCodes
     * @return
     */
    List<String> findAuthorityByRoleCodes(List<String> roleCodes);

    /**
     * 根据用户角色查询用户权限
     * @param email
     * @return
     */
    List<String> findAuthorityByEmail(String email);
}

