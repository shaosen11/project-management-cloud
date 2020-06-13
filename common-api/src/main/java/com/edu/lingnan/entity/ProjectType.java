package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectType)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:04
 */
@Data
@Table("project_management_project_cloud.project_type")
public class ProjectType implements Serializable {
    /**
    * 自增id,项目类型
    */
    @Id
    private Integer id;
    /**
    * 项目类型
    */
    private String type;


}