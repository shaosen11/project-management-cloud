package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysRoleMenu)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:36
 */
@Data
public class SysRoleMenu implements Serializable {

    private Integer id;
    /**
    * 角色id
    */
    private Integer roleId;
    /**
    * 权限id
    */
    private Integer menuId;


}