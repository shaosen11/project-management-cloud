package com.edu.lingnan.feign;

import com.edu.lingnan.entity.Document;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Document)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:10:11
 */
@Component
@FeignClient(value = "PROVIDER-DOCUMENT")
public interface DocumentFeignService {

    @GetMapping("document/{id}")
    Document getById(Integer id);

    @GetMapping("document/getByProjectIdAndVersionAndName/{projectId}/{version}/{name}")
    Document getByProjectIdAndVersionAndName(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("version") Integer version,
            @PathVariable("name") String name);

    @GetMapping("document/getByProjectIdAndVersionFlagAndName/{projectId}/{versionflag}/{name}")
    Document getByProjectIdAndVersionFlagAndName(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("versionflag") Integer versionflag,
            @PathVariable("name") String name);

    @GetMapping("document/getVersionByProjectIdAndName/{projectId}/{name}")
    Integer getVersionByProjectIdAndName(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("name") String name);

    @GetMapping("document/{id}")
    boolean delete(@PathVariable("id") Integer id);

    @PutMapping("document/")
    boolean update(Document document);

    @PostMapping("document/")
    boolean insert(Document document);

    @GetMapping("document/getAllDeleteDocument")
    List<Document> getAllDeleteDocument();

    @PutMapping("document/undo/{id}")
    boolean undo(@PathVariable("id") Integer id);
}