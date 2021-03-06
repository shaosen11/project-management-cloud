package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (ProjectRecord)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:13:52
 */
@Data
@Table("project_management_project_cloud.project_record")
public class ProjectRecord implements Serializable {

    @Id
    private Integer id;
    
    private Integer projectsId;
    
    private Integer userId;
    
    private Date operateTime;
    
    private String operateMassge;
    
    private String ip;
    
    private Integer deleteFlag;


}