package com.edu.lingnan.feign;

import com.edu.lingnan.entity.ProjectMessageNeedToDoRelationship;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * (ProjectMessageNeedToDoRelationship)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:13:34
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface ProjectMessageNeedToDoRelationshipFeignService {

    @GetMapping("projectMessageNeedToDoRelationship/getByProjectMessageId/{projectMessageId}")
    ProjectMessageNeedToDoRelationship getByProjectMessageId(@RequestParam("projectMessageId") Integer projectMessageId);

    @GetMapping("projectMessageNeedToDoRelationship/getByDocumentId/{documentId}")
    ProjectMessageNeedToDoRelationship getByDocumentId(@RequestParam("documentId") Integer documentId);

    @PostMapping("projectMessageNeedToDoRelationship/")
    void insert(ProjectMessageNeedToDoRelationship projectsMessageNeedToDoRelationship);
}