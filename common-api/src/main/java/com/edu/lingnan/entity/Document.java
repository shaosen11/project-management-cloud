package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
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
@Table("project_management_document_cloud.document")
public class Document implements Serializable {

    @Id
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