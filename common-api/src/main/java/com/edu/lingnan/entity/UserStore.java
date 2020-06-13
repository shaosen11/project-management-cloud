package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
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
@Table("project_management_user_cloud.user_store")
public class UserStore implements Serializable {

    @Id
    private Integer id;
    
    private Integer userId;
    
    private Integer projectsId;
    
    private Integer deleteFlag;
    
    private Date storeTime;


}