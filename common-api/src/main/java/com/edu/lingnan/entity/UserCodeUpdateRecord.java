package com.edu.lingnan.entity;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * (UserCodeUpdateRecord)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:14:57
 */
@Data
@Table("project_management_user_cloud.user_code_update_record")
public class UserCodeUpdateRecord implements Serializable {
    /**
    * 自增id
    */
    @Id
    private Integer id;
    /**
    * 用户id
    */
    private Integer userid;
    /**
    * 时间
    */
    private Object time;
    /**
    * 代码上传次数
    */
    private Integer codeUpdateCount;
    /**
    * 是否删除
    */
    private Integer deleteFlag;


}