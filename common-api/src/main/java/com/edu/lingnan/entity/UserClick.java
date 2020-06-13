package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserClick)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:52
 */
@Data
@Table("project_management_user_cloud.user_click")
public class UserClick implements Serializable {

    @Id
    private Integer id;
    
    private Integer userId;
    
    private Integer projectsId;
    
    private Date clickTime;
    
    private Integer deleteFlag;



}