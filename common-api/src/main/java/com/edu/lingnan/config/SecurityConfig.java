package com.edu.lingnan.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author shaosen
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //跨域请求
                .csrf().disable()
                //需要权限的请求
                .authorizeRequests()
                //允许所有访问
                .antMatchers("/**").permitAll();
    }


}

