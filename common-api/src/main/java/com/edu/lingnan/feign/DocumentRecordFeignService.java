package com.edu.lingnan.feign;

import com.edu.lingnan.entity.DocumentRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (DocumentRecord)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:10:32
 */
@Component
@FeignClient(value = "PROVIDER-DOCUMENT")
public interface DocumentRecordFeignService {

    @GetMapping("documentRecord/getAllByProjectId/{projectId}")
    List<DocumentRecord> getAllByProjectId(@RequestParam("projectId") Integer projectId) ;

    @DeleteMapping("documentRecord/{id}")
    boolean delete(@RequestParam("id") Integer id);

    @PutMapping("documentRecord/")
    boolean update(DocumentRecord documentRecord);

    @PostMapping("documentRecord/")
    boolean insert(DocumentRecord documentRecord);

    @GetMapping("documentRecord/getAllDeleteDocumentRecord")
    List<DocumentRecord> getAllDeleteDocumentRecord();

    @PutMapping("documentRecord/undo/{id}")
    boolean undo(@RequestParam("id") Integer id);

    @GetMapping("documentRecord/getDocumentRecordCountByProjectId/{projectId}")
    Integer getDocumentRecordCountByProjectId(@RequestParam("projectId") Integer projectId);

    @GetMapping("documentRecord/getDocumentRecordCountByProjectIdAndUserId/{projectId}/{userId}")
    Integer getDocumentRecordCountByProjectIdAndUserId(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("userId") Integer userId);

    @GetMapping("documentRecord/getDocumentRecordPageByProjectId/{projectId}/{offset}/{pageSize}")
    List<DocumentRecord> getDocumentRecordPageByProjectId(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("offset") Integer offset,
            @RequestParam("pageSize") Integer pageSize);

    @GetMapping("documentRecord/getDocumentRecordPageByProjectIdAndUserId/{projectId}/{userId}/{offset}/{pageSize}")
    List<DocumentRecord> getDocumentRecordPageByProjectIdAndUserId(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("userId") Integer userId,
            @RequestParam("offset") Integer offset,
            @RequestParam("pageSize") Integer pageSize);
}