package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysUserRole)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:47
 */
@Data
public class SysUserRole implements Serializable {

    private Integer id;
    /**
    * 用户自增id
    */
    private Integer userId;
    /**
    * 角色自增id
    */
    private Integer roleId;


}