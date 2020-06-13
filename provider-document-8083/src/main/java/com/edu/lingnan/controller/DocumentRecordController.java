package com.edu.lingnan.controller;

import com.edu.lingnan.entity.DocumentRecord;
import com.edu.lingnan.feign.DocumentRecordFeignService;
import com.edu.lingnan.service.DocumentRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DocumentRecord)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:20:06
 */
@RestController
@RequestMapping("documentRecord")
public class DocumentRecordController {
    /**
     * 服务对象
     */
    @Resource
    private DocumentRecordService documentRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DocumentRecord selectOne(Integer id) {
        return this.documentRecordService.queryById(id);
    }

}