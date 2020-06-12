package com.edu.lingnan.entity;

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
public class ProjectRecord implements Serializable {

    private Integer id;
    
    private Integer projectsId;
    
    private Integer userId;
    
    private Date operateTime;
    
    private String operateMassge;
    
    private String ip;
    
    private Integer deleteFlag;


}