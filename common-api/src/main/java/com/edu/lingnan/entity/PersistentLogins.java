package com.edu.lingnan.entity;

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
public class PersistentLogins implements Serializable {

    private String username;
    
    private String series;
    
    private String token;
    
    private Date lastUsed;


}