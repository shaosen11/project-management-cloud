package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (ProjectUserCooperation)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:14
 */
@Data
@Table("project_management_project_cloud.project_user_cooperation")
public class ProjectUserCooperation implements Serializable {
    /**
    * 自增id
    */
    @Id
    private Integer id;
    /**
    * 项目id
    */
    private Integer projectsId;
    /**
    * 在项目的用户id
    */
    private Integer inProjectUserId;
    /**
    * 不在项目的用户id
    */
    private Integer notInProjectUserId;
    /**
    * 项目角色id
    */
    private Integer dutyCode;
    /**
    * 时间
    */
    private Date time;
    /**
    * 是否删除
    */
    private Integer deleteFlag;
    /**
    * 是不是邀请记录，1是
    */
    private Integer inviteFlag;
    /**
    * 是不是加入记录，1是
    */
    private Integer joinFlag;
    /**
    * 是否完成邀请或加入，0是未完成，1是完成
    */
    private Integer finishFlag;
    /**
    * 标志是否成，1为成功，-1位拒绝
    */
    private Integer successFlag;


}