package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectUserDuty)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:20
 */
@Data
public class ProjectUserDuty implements Serializable {

    private Integer id;
    
    private String dutyName;
    
    private Integer deleteFlag;


}