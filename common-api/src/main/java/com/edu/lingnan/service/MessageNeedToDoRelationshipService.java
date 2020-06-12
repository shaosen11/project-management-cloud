package com.edu.lingnan.service;

import com.edu.lingnan.entity.MessageNeedToDoRelationship;
import java.util.List;

/**
 * (MessageNeedToDoRelationship)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:10:53
 */
public interface MessageNeedToDoRelationshipService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MessageNeedToDoRelationship queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MessageNeedToDoRelationship> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param messageNeedToDoRelationship 实例对象
     * @return 实例对象
     */
    MessageNeedToDoRelationship insert(MessageNeedToDoRelationship messageNeedToDoRelationship);

    /**
     * 修改数据
     *
     * @param messageNeedToDoRelationship 实例对象
     * @return 实例对象
     */
    MessageNeedToDoRelationship update(MessageNeedToDoRelationship messageNeedToDoRelationship);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}