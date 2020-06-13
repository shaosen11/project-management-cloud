package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * (SysMenu)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:25
 */
@Data
@Table("project_management_user_cloud.sys_menu")
public class SysMenu implements Serializable {

    @Id
    private Integer id;
    /**
    * 菜单名称
    */
    private String menuName;
    /**
    * 跳转URL
    */
    private String url;
    
    private Integer status;


}