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

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MessageType queryById(Integer id) {
        return this.messageTypeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MessageType> queryAllByLimit(int offset, int limit) {
        return this.messageTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param messageType 实例对象
     * @return 实例对象
     */
    @Override
    public MessageType insert(MessageType messageType) {
        this.messageTypeDao.insert(messageType);
        return messageType;
    }

    /**
     * 修改数据
     *
     * @param messageType 实例对象
     * @return 实例对象
     */
    @Override
    public MessageType update(MessageType messageType) {
        this.messageTypeDao.update(messageType);
        return this.queryById(messageType.getId());
    }

}