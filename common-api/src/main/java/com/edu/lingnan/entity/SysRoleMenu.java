package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * (SysRoleMenu)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:36
 */
@Data
@Table("project_management_user_cloud.sys_role_menu")
public class SysRoleMenu implements Serializable {

    @Id
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