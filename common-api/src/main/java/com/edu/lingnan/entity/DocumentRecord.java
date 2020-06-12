package com.edu.lingnan.entity;

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
public class DocumentRecord implements Serializable {

    private Integer id;
    
    private Integer projectId;
    
    private Integer userId;
    
    private Date operateTime;
    
    private String operateMessage;
    
    private String ip;
    
    private Integer deleteFlag;



}