package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Document;
import com.edu.lingnan.feign.DocumentFeignService;
import com.edu.lingnan.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Document)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:19:38
 */
@RestController
@RequestMapping("document")
public class DocumentController {
    /**
     * 服务对象
     */
    @Resource
    private DocumentService documentService;

    @GetMapping("/{id}")
    Document getById(Integer id) {
        return documentService.getById(id);
    }

    @GetMapping("getByProjectIdAndVersionAndName/{projectId}/{version}/{name}")
    Document getByProjectIdAndVersionAndName(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("version") Integer version,
            @PathVariable("name") String name) {
        return documentService.getByProjectIdAndVersionAndName(projectId, version, name);
    }

    @GetMapping("getByProjectIdAndVersionFlagAndName/{projectId}/{versionflag}/{name}")
    Document getByProjectIdAndVersionFlagAndName(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("versionflag") Integer versionflag,
            @PathVariable("name") String name) {
        return documentService.getByProjectIdAndVersionFlagAndName(projectId, versionflag, name);
    }

    @GetMapping("getVersionByProjectIdAndName/{projectId}/{name}")
    Integer getVersionByProjectIdAndName(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("name") String name) {
        return documentService.getVersionByProjectIdAndName(projectId, name);
    }

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Integer id) {
        return documentService.delete(id);
    }

    @PutMapping("/")
    boolean update(Document document) {
        return documentService.update(document);
    }

    @PostMapping("/")
    boolean insert(Document document) {
        return documentService.insert(document);
    }

    @GetMapping("getAllDeleteDocument")
    List<Document> getAllDeleteDocument() {
        return documentService.getAllDeleteDocument();
    }

    @PutMapping("undo/{id}")
    boolean undo(@PathVariable("id") Integer id) {
        return documentService.undo(id);
    }

}