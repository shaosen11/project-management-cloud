package com.edu.lingnan.feign;

import com.edu.lingnan.entity.MessageType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (MessageType)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:10:58
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface MessageTypeFeignService {

//    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    MessageType queryById(Integer id);
//
//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<MessageType> queryAllByLimit(int offset, int limit);
//
//    /**
//     * 新增数据
//     *
//     * @param messageType 实例对象
//     * @return 实例对象
//     */
//    MessageType insert(MessageType messageType);
//
//    /**
//     * 修改数据
//     *
//     * @param messageType 实例对象
//     * @return 实例对象
//     */
//    MessageType update(MessageType messageType);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    boolean deleteById(Integer id);

}