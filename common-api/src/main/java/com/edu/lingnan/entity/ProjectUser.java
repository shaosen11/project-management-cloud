package com.edu.lingnan.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (ProjectUser)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:09
 */
@Data
public class ProjectUser implements Serializable {

    private Integer id;
    
    private Integer projectsId;
    
    private Integer userId;
    /**
    * 1是创建人，2是管理员，3是开发者
    */
    private Integer dutyCode;
    
    private Integer codeDevoteLine;
    
    private Integer codeUpdate;
    
    private Integer deleteFlag;
    /**
    * 加入项目时间
    */
    private Date joinTime;


}