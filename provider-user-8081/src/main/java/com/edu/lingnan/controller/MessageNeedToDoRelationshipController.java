package com.edu.lingnan.controller;

import com.edu.lingnan.entity.MessageNeedToDoRelationship;
import com.edu.lingnan.feign.MessageNeedToDoRelationshipFeignService;
import com.edu.lingnan.service.MessageNeedToDoRelationshipService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MessageNeedToDoRelationship)表控制层
 *
 * @author makejava
 * @since 2020-06-12 14:59:05
 */
@RestController
@RequestMapping("messageNeedToDoRelationship")
public class MessageNeedToDoRelationshipController {
    /**
     * 服务对象
     */
    @Resource
    private MessageNeedToDoRelationshipService messageNeedToDoRelationshipService;

    @GetMapping("getByMessageId/{messageId}")
    MessageNeedToDoRelationship getByMessageId(@PathVariable("messageId") Integer messageId) {
        return messageNeedToDoRelationshipService.getByMessageId(messageId);
    }

    @GetMapping("getByProjectsUserCooperationId/{projectsUserCooperationId}")
    MessageNeedToDoRelationship getByProjectsUserCooperationId(
            @PathVariable("projectsUserCooperationId") Integer projectsUserCooperationId) {
        return messageNeedToDoRelationshipService.getByProjectsUserCooperationId(projectsUserCooperationId);
    }

    @PostMapping("/")
    boolean insert(MessageNeedToDoRelationship messageNeedToDoRelationship){
        return messageNeedToDoRelationshipService.insert(messageNeedToDoRelationship);
    }

}