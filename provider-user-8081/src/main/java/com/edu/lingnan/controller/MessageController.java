package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Message;
import com.edu.lingnan.feign.MessageFeignService;
import com.edu.lingnan.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Message)表控制层
 *
 * @author makejava
 * @since 2020-06-12 14:58:52
 */
@RestController
@RequestMapping("message")
public class MessageController {
    /**
     * 服务对象
     */
    @Autowired
    private MessageService messageService;


    @GetMapping("get/{id}")
    public Message getById(@PathVariable("id") Integer id){
        return messageService.queryById(id);
    }

}