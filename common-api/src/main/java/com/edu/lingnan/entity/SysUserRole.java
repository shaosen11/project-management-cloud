package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * (SysUserRole)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:47
 */
@Data
@Table("project_management_user_cloud.sys_user_role")
public class SysUserRole implements Serializable {

    @Id
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