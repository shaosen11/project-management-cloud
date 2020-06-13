package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:41
 */
@Data
@Table("project_management_user_cloud.sys_user")
public class SysUser implements Serializable {

    @Id
    private Integer id;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 手机号
    */
    private String phone;
    /**
    * 出生日期
    */
    private Object birthday;
    /**
    * 性别，0表示女，1表示男
    */
    private Integer gender;
    /**
    * 地址
    */
    private String address;
    /**
    * 简介
    */
    private String introduce;
    
    private String tag;
    /**
    * 头像URL
    */
    private String photo;
    /**
    * 最近登录时间
    */
    private Date lastLoginTime;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 0无效用户，1是有效用户
    */
    private Integer enabled;
    /**
    * 是否过期
    */
    private Integer accountNonExpired;
    /**
    * 是否被锁
    */
    private Integer accountNonLocked;
    /**
    * 证书是否过期
    */
    private Integer credentialNonExpired;
    /**
    * 邮箱找回秘钥
    */
    private String validataCode;
    /**
    * 邮箱找回过期时间
    */
    private Date outDate;


}