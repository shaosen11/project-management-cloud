package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (MessageNeedToDoRelationship)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:10:53
 */
@Data
public class MessageNeedToDoRelationship implements Serializable {
    /**
    * 自增id
    */
    private Integer id;
    /**
    * messageid
    */
    private Integer messageId;
    /**
    * 项目邀请表id
    */
    private Integer projectsUserCooperrationId;
    /**
    * 1表示可用，0表示删除
    */
    private Integer deleteFlag;


}