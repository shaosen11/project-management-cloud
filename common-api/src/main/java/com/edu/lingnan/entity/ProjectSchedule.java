package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectSchedule)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:13:57
 */
@Data
@Table("project_management_project_cloud.project_schedule")
public class ProjectSchedule implements Serializable {
    /**
    * 自增id
    */
    @Id
    private Integer id;
    /**
    * 项目进度
    */
    private String schedule;


}