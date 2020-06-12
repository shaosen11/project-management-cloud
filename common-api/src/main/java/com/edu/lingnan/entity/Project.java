package com.edu.lingnan.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Project)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:12:40
 */
@Data
public class Project implements Serializable {
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 项目名称
    */
    private String name;
    /**
    * 创建人id
    */
    private Integer chargeUserId;
    /**
    * 上传次数统计
    */
    private Integer codeLineNumber;
    /**
    * 上传代码行统计
    */
    private Integer codeUpdateCount;
    /**
    * 进度
    */
    private Integer scheduleId;
    /**
    * 项目功能点数量
    */
    private Integer functionPoints;
    /**
    * 完成功能点数量
    */
    private Integer completedFunctionPoints;
    /**
    * 最近更新时间
    */
    private Date lastUpdateTime;
    /**
    * 项目类型
    */
    private Integer typeId;
    /**
    * 收藏数
    */
    private Integer storeCount;
    /**
    * 点赞数
    */
    private Integer likeCount;
    /**
    * 点击量
    */
    private Integer clickCount;
    /**
    * 旧版：是否删除，1为删除，新版：是否删除，1为不删除
    */
    private Integer deleteFlag;
    /**
    * 简介
    */
    private String characterization;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 项目人数
    */
    private Integer userCount;
    /**
    * 文件数量
    */
    private Integer documentCount;
    /**
    * 计划开始时间
    */
    private Object plannedStartTime;
    /**
    * 计划结束时间
    */
    private Object plannedEndTime;
    /**
    * 实际开始时间
    */
    private Object actualStartTime;
    /**
    * 实际结束时间
    */
    private Object actualEndTime;


}