package com.edu.lingnan.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Document)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:10:08
 */
@Data
public class Document implements Serializable {

    private Integer id;
    
    private String name;
    
    private Integer userId;
    
    private Integer version;
    
    private String versionMessage;
    
    private String serialNumber;
    
    private Integer projectId;
    
    private Date uploadTime;
    
    private Integer versionFlag;
    
    private Integer codeLineNumber;
    
    private Integer deleteFlag;

}