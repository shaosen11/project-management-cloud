package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectFunction)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:13:23
 */
@Data
@Table("project_manaproject_management_project_cloudgement_user_cloud.project_function")
public class ProjectFunction implements Serializable {

    @Id
    private Integer id;
    
    private Integer projectsId;

    private String projectsName;
    
    private Integer functionId;
    
    private String functionName;
    
    private Integer functionStatus;
    
    private Integer publishUserId;

    private String publishUserName;
    
    private Integer realizeUserId;

    private String realizeUserName;
    
    private Object plannedStartTime;
    
    private Object plannedEndTime;
    
    private Object actualStartTime;
    
    private Object actualEndTime;
    
    private Integer deleteFlag;
    
    private String delReason;
    /**
    * 描述
    */
    private String description;


}