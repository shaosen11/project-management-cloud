package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Message;
import com.edu.lingnan.feign.MessageFeignService;
import com.edu.lingnan.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("getByUserIdAndNeedToDo/{userId}/{needToDo}")
    public List<Message> getByUserIdAndNeedToDo(@PathVariable("userId") Integer userId, @PathVariable("needToDo") Integer needToDo) {
        return messageService.getByUserIdAndNeedToDo(userId, needToDo);
    }

    @GetMapping("getByUserIdAndOffsetAndPageSize/{userId}/{needToDo}/{offset}/{pageSize}")
    public List<Message> getByUserIdAndOffsetAndPageSize(@PathVariable("userId") Integer userId,
                                                         @PathVariable("needToDo") Integer needToDo,
                                                         @PathVariable("offset") Integer offset,
                                                         @PathVariable("pageSize") Integer pageSize) {
        return messageService.getByUserIdAndOffsetAndPageSize(userId, needToDo, offset, pageSize);
    }

    @PostMapping("/")
    boolean insert(Message message) {
        return messageService.insert(message);
    }

    @PutMapping("updateAllMessageIsReadByUserId/{userId}/{isRead}")
    boolean updateAllMessageIsReadByUserId(@PathVariable("userId") Integer userId,
                                           @PathVariable("isRead") Integer isRead) {
        return messageService.updateAllMessageIsReadByUserId(userId, isRead);
    }

    @GetMapping("/{id}")
    Message getById(@PathVariable("id") Integer id) {
        return messageService.getById(id);
    }

    @PutMapping("/")
    boolean update(Message message) {
        return messageService.update(message);
    }

    @PutMapping("updateMessageIsReadByMessageId/{messageId}/{isRead}")
    boolean updateMessageIsReadByMessageId(@PathVariable("messageId") Integer messageId,
                                           @PathVariable("isRead") Integer isRead) {
        return messageService.updateMessageIsReadByMessageId(messageId, isRead);
    }

    @GetMapping("getMessageCount/{userId}")
    Integer getMessageCount(@PathVariable("userId") Integer userId) {
        return messageService.getMessageCount(userId);
    }

    @GetMapping("getMessageNeedToDoCount/{userId}")
    Integer getMessageNeedToDoCount(@PathVariable("userId") Integer userId) {
        return messageService.getMessageNeedToDoCount(userId);
    }

}