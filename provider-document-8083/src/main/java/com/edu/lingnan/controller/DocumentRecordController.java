package com.edu.lingnan.controller;

import com.edu.lingnan.entity.DocumentRecord;
import com.edu.lingnan.feign.DocumentRecordFeignService;
import com.edu.lingnan.service.DocumentRecordService;
import com.edu.lingnan.utils.DateFromatUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("getAllByProjectId/{projectId}")
    List<DocumentRecord> getAllByProjectId(@PathVariable("projectId") Integer projectId) {
        return documentRecordService.getAllByProjectId(projectId);
    }

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Integer id) {
        return documentRecordService.delete(id);
    }

    @PutMapping("/")
    boolean update(DocumentRecord documentRecord) {
        return documentRecordService.update(documentRecord);
    }

    @PostMapping("/")
    boolean insert(DocumentRecord documentRecord) {
        return documentRecordService.insert(documentRecord);
    }

    @GetMapping("getAllDeleteDocumentRecord")
    List<DocumentRecord> getAllDeleteDocumentRecord() {
        return documentRecordService.getAllDeleteDocumentRecord();
    }

    @PutMapping("undo/{id}")
    boolean undo(@PathVariable("id") Integer id) {
        return documentRecordService.undo(id);
    }

    @GetMapping("getDocumentRecordCountByProjectId/{projectId}")
    Integer getDocumentRecordCountByProjectId(@PathVariable("projectId") Integer projectId) {
        return documentRecordService.getDocumentRecordCountByProjectId(projectId);
    }

    @GetMapping("getDocumentRecordCountByProjectIdAndUserId/{projectId}/{userId}")
    Integer getDocumentRecordCountByProjectIdAndUserId(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("userId") Integer userId) {
        return documentRecordService.getDocumentRecordCountByProjectIdAndUserId(projectId, userId);
    }

    @GetMapping("getDocumentRecordPageByProjectId/{projectId}/{offset}/{pageSize}")
    List<DocumentRecord> getDocumentRecordPageByProjectId(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("offset") Integer offset,
            @PathVariable("pageSize") Integer pageSize) {
        return documentRecordService.getDocumentRecordPageByProjectId(projectId, offset, pageSize);
    }

    @GetMapping("getDocumentRecordPageByProjectIdAndUserId/{projectId}/{userId}/{offset}/{pageSize}")
    List<DocumentRecord> getDocumentRecordPageByProjectIdAndUserId(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("userId") Integer userId,
            @PathVariable("offset") Integer offset,
            @PathVariable("pageSize") Integer pageSize) {
        return documentRecordService.getDocumentRecordPageByProjectIdAndUserId(projectId, userId, offset, pageSize);
    }

}