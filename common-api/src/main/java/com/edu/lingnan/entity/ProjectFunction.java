package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectFunction)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:13:23
 */
@Data
public class ProjectFunction implements Serializable {

    private Integer id;
    
    private Integer projectsId;
    
    private Integer functionId;
    
    private String functionName;
    
    private Integer functionStatus;
    
    private Integer publishUserId;
    
    private Integer realizeUserId;
    
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