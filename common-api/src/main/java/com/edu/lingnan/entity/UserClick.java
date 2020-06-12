package com.edu.lingnan.entity;

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
public class UserClick implements Serializable {

    private Integer id;
    
    private Integer userId;
    
    private Integer projectsId;
    
    private Date clickTime;
    
    private Integer deleteFlag;



}