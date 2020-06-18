package com.edu.lingnan.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author shaosen
 */
public interface MyRBACService {
    /**
     * 获取用户权限
     * @param request
     * @param authentication
     * @return
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);

    List<String> findUrlsByEmail(String email);
}

