package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
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
@Table("project_management_user_cloud.user_record")
public class UserRecord implements Serializable {

    @Id
    private Integer id;
    
    private Integer userId;
    
    private Date operateTime;
    
    private String operateMassage;
    
    private String ip;



}