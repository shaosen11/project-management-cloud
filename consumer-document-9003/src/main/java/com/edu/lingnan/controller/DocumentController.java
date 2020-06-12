package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Document;
import com.edu.lingnan.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Document)表控制层
 *
 * @author makejava
 * @since 2020-06-11 23:49:00
 */
@RestController
@RequestMapping("document")
public class DocumentController {
    /**
     * 服务对象
     */
    @Autowired
    private DocumentService documentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public Document selectOne(@PathVariable("id") Integer id) {
        return this.documentService.queryById(id);
    }

}