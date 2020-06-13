package com.edu.lingnan.service;

import com.edu.lingnan.entity.Document;
import java.util.List;

/**
 * (Document)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:18:50
 */
public interface DocumentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Document queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Document> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    Document insert(Document document);

    /**
     * 修改数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    Document update(Document document);


}