package com.edu.lingnan.feign;

import com.edu.lingnan.entity.MessageNeedToDoRelationship;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * (MessageNeedToDoRelationship)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:10:53
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface MessageNeedToDoRelationshipFeignService {

    @GetMapping("/messageNeedToDoRelationship/getByMessageId/{messageId}")
    MessageNeedToDoRelationship getByMessageId(@RequestParam("messageId") Integer messageId);

    @GetMapping("/messageNeedToDoRelationship/getByProjectsUserCooperationId/{projectsUserCooperationId}")
    MessageNeedToDoRelationship getByProjectsUserCooperationId(
            @RequestParam("projectsUserCooperationId") Integer projectsUserCooperationId);

    @PostMapping("/messageNeedToDoRelationship")
    boolean insert(MessageNeedToDoRelationship messageNeedToDoRelationship);
}