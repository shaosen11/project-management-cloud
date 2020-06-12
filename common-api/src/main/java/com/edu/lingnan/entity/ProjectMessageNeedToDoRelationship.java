package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectMessageNeedToDoRelationship)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:13:34
 */
@Data
public class ProjectMessageNeedToDoRelationship implements Serializable {
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 项目消息id
    */
    private Integer projectMessageId;
    /**
    * 待审核文件id
    */
    private Integer documentId;
    /**
    * 1代表可用，0表示删除
    */
    private Integer deleteFlag;


}