package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysMenu)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:25
 */
@Data
public class SysMenu implements Serializable {

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