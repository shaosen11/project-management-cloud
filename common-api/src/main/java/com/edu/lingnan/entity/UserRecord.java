package com.edu.lingnan.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserRecord)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:15:09
 */
@Data
public class UserRecord implements Serializable {

    private Integer id;
    
    private Integer userId;
    
    private Date operateTime;
    
    private String operateMassage;
    
    private String ip;



}