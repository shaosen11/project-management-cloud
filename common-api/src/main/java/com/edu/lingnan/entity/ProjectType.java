package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectType)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:04
 */
@Data
public class ProjectType implements Serializable {
    /**
    * 自增id,项目类型
    */
    private Integer id;
    /**
    * 项目类型
    */
    private String type;


}