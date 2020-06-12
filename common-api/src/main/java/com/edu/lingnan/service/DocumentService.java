package com.edu.lingnan.service;

import com.edu.lingnan.entity.Document;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Document)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:10:11
 */
@Component
@FeignClient(value = "PROVIDER-DOCUMENT")
public interface DocumentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping("document/selectOne/{id}")
    Document queryById(@PathVariable("id") Integer id);

//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<Document> queryAllByLimit(int offset, int limit);
//
//    /**
//     * 新增数据
//     *
//     * @param document 实例对象
//     * @return 实例对象
//     */
//    Document insert(Document document);
//
//    /**
//     * 修改数据
//     *
//     * @param document 实例对象
//     * @return 实例对象
//     */
//    Document update(Document document);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    boolean deleteById(Integer id);

}