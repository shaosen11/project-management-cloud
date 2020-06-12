package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectCodeLine)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:12:46
 */
@Data
public class ProjectCodeLine implements Serializable {
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 项目id
    */
    private Integer projectsId;
    /**
    * 代码行
    */
    private Integer codeLineNumber;
    /**
    * 项目时间
    */
    private Object uploadTime;
    /**
    * 是否删除，1为不删除
    */
    private Integer deleteFlag;



}