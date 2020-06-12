package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Message)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:10:46
 */
@Data
public class Message implements Serializable {
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 消息类型
    */
    private Integer typeId;
    /**
    * 来自哪里
    */
    private Integer fromUserId;
    /**
    * 给谁
    */
    private Integer toUserId;
    /**
    * 消息体
    */
    private String message;
    /**
    * 时间
    */
    private String time;
    /**
    * 是否已读，1未读，0已读
    */
    private Integer isRead;
    /**
    * 是否删除，1不删，0删除
    */
    private Integer deleteFlag;
    /**
    * 是否需要去做，1表示需要去做，为代办，0表示不需要去做，为通知
    */
    private Integer needToDo;


}