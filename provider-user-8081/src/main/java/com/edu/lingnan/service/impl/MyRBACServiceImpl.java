package com.edu.lingnan.service.impl;

import com.edu.lingnan.dao.MyRBACServiceDao;
import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.service.MyRBACService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author shaosen
 */
@Component("rbacService")
public class MyRBACServiceImpl implements MyRBACService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private MyRBACServiceDao myRBACServiceDao;

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();

        if(principal instanceof UserDetails){
            String email = ((MyUserDetails)principal).getEmail();
            List<String> urls = myRBACServiceDao.findUrlsByEmail(email);
            //通过查询到的url来匹配我们可以访问的url
            return urls.stream().anyMatch(
                    url ->antPathMatcher.match(url,request.getRequestURI())
            );
        }
        return false;
    }

    @Override
    public List<String> findUrlsByEmail(String email) {
        return myRBACServiceDao.findUrlsByEmail(email);
    }


}
