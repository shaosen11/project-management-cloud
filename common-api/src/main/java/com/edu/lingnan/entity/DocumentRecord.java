package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (DocumentRecord)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:10:32
 */
@Data
@Table("project_management_document_cloud.document")
public class DocumentRecord implements Serializable {

    @Id
    private Integer id;
    
    private Integer projectId;
    
    private Integer userId;
    
    private Date operateTime;
    
    private String operateMessage;
    
    private String ip;
    
    private Integer deleteFlag;



}