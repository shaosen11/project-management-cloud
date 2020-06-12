package com.edu.lingnan.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (ProjectPackage)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:13:47
 */
@Data
public class ProjectPackage implements Serializable {

    private Integer id;
    
    private Integer projectId;
    
    private Integer packageId;
    
    private String documentName;
    
    private String packageName;
    
    private Date createTime;
    
    private Integer userId;
    
    private Integer deleteFlag;


}