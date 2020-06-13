package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Document;
import com.edu.lingnan.feign.DocumentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Document)表控制层
 *
 * @author makejava
 * @since 2020-06-11 23:49:00
 */
@RestController
@RequestMapping("document")
public class ConsumerDocumentController {
    /**
     * 服务对象
     */
    @Autowired
    private DocumentFeignService documentFeignService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    public Document selectOne(@PathVariable("id") Integer id) {
        return documentFeignService.queryById(id);
    }

}