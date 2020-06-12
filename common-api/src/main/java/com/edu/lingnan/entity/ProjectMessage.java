package com.edu.lingnan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectMessage)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:13:29
 */
@Data
public class ProjectMessage implements Serializable {
    /**
    * 自增
    */
    private Integer id;
    /**
    * 项目id
    */
    private Integer projectId;
    /**
    * 来自谁，可以为空
    */
    private Integer fromUserId;
    /**
    * 给谁用户id
    */
    private Integer toUserId;
    /**
    * 消息类型
    */
    private Integer typeId;
    /**
    * 消息体
    */
    private String message;
    /**
    * 时间
    */
    private String time;
    /**
    * 1表示需要读
    */
    private Integer isRead;
    /**
    * 1代表可用，0代表删除
    */
    private Integer deleteFlag;
    /**
    * 1代表项目所有人可见
    */
    private Integer allFlag;
    /**
    * 1代表仅管理员可见
    */
    private Integer adminFlag;
    /**
    * 1代表需要去处理
    */
    private Integer needToDo;


}