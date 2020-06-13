package com.edu.lingnan.controller;

import com.edu.lingnan.feign.MessageTypeFeignService;
import com.edu.lingnan.service.MessageTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MessageType)表控制层
 *
 * @author makejava
 * @since 2020-06-12 14:59:13
 */
@RestController
@RequestMapping("messageType")
public class MessageTypeController {
    /**
     * 服务对象
     */
    @Resource
    private MessageTypeService messageTypeService;


}