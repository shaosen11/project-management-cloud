package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * (MessageType)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:10:58
 */
@Data
@Table("project_management_user_cloud.message_type")
public class MessageType implements Serializable {
    /**
    * 消息码
    */
    @Id
    private Integer id;
    /**
    * 消息名
    */
    private String type;
    /**
    * 图标
    */
    private String icon;
    /**
    * 背景色
    */
    private String background;
    /**
    * 1表示可用，0表示删除
    */
    private Integer deleteFlag;
    /**
    * 消息页面背景色
    */
    private String background2;


}