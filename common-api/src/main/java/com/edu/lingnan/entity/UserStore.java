package com.edu.lingnan.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserStore)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:15:15
 */
@Data
public class UserStore implements Serializable {

    private Integer id;
    
    private Integer userId;
    
    private Integer projectsId;
    
    private Integer deleteFlag;
    
    private Date storeTime;


}