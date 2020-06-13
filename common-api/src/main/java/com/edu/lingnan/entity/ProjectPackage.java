package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
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
@Table("project_management_project_cloud.project_package")
public class ProjectPackage implements Serializable {

    @Id
    private Integer id;
    
    private Integer projectId;
    
    private Integer packageId;
    
    private String documentName;
    
    private String packageName;
    
    private Date createTime;
    
    private Integer userId;
    
    private Integer deleteFlag;


}