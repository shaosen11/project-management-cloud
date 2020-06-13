package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:31
 */
@Data
@Table("project_management_user_cloud.sys_role")
public class SysRole implements Serializable {

    @Id
    private Integer id;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 角色的英文code
    */
    private String roleCode;
    /**
    * 角色描述
    */
    private String roleDesc;
    /**
    * 角色排序
    */
    private Integer sort;
    
    private Integer status;
    /**
    * 角色创建日期
    */
    private Date createTime;


}