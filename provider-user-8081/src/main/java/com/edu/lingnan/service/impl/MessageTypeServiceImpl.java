package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.MessageType;
import com.edu.lingnan.dao.MessageTypeDao;
import com.edu.lingnan.feign.MessageTypeFeignService;
import com.edu.lingnan.service.MessageTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MessageType)表服务实现类
 *
 * @author makejava
 * @since 2020-06-12 14:59:13
 */
@Service("messageTypeService")
public class MessageTypeServiceImpl implements MessageTypeService {
    @Resource
    private MessageTypeDao messageTypeDao;


    @Override
    public MessageType getById(Integer id) {
        return messageTypeDao.getById(id);
    }
}