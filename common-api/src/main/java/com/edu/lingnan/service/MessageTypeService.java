package com.edu.lingnan.service;

import com.edu.lingnan.entity.MessageType;
import java.util.List;

/**
 * (MessageType)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:15:48
 */
public interface MessageTypeService {

    /**
     * 通过消息码得到消息类型
     * @param id
     * @return
     */
    MessageType getById(Integer id);


}