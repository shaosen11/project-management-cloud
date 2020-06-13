package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (PersistentLogins)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:11:04
 */
@Data
@Table("project_management_user_cloud.persistent_logins")
public class PersistentLogins implements Serializable {

    private String username;
    
    private String series;
    
    private String token;
    
    private Date lastUsed;


}