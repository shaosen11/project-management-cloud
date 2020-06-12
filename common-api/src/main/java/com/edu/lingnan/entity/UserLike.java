package com.edu.lingnan.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserLike)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:15:04
 */
@Data
public class UserLike implements Serializable {

    private Integer id;
    
    private Integer userId;
    
    private Integer projectsId;
    
    private Date likeTime;
    
    private Integer deleteFlag;


}