package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectUserDuty)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:20
 */
@Data
@Table("project_management_project_cloud.project_user_duty")
public class ProjectUserDuty implements Serializable {

    @Id
    private Integer id;
    
    private String dutyName;
    
    private Integer deleteFlag;


}