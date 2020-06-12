package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectSchedule)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:13:57
 */
@Data
public class ProjectSchedule implements Serializable {
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 项目进度
    */
    private String schedule;


}