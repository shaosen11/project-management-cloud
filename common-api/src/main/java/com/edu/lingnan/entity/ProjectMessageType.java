package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * (ProjectMessageType)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:13:41
 */
@Data
@Table("project_management_project_cloud.project_message_type")
public class ProjectMessageType implements Serializable {
    /**
    * 自增id
    */
    @Id
    private Integer id;
    /**
    * 类型名称
    */
    private String type;
    /**
    * 网页图标
    */
    private String icon;
    /**
    * 背景颜色
    */
    private String background;
    /**
    * 1代表可用，0代表删除
    */
    private Integer deleteFlag;


}