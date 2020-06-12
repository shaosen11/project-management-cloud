package com.edu.lingnan.entity;

import java.io.Serializable;

/**
 * (MessageType)实体类
 *
 * @author makejava
 * @since 2020-06-11 20:10:58
 */
public class MessageType implements Serializable {
    private static final long serialVersionUID = 142876975947995659L;
    /**
    * 消息码
    */
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getBackground2() {
        return background2;
    }

    public void setBackground2(String background2) {
        this.background2 = background2;
    }

}