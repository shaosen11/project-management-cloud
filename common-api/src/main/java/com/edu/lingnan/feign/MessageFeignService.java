package com.edu.lingnan.feign;

import com.edu.lingnan.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * (Message)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:10:46
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface MessageFeignService {

    @GetMapping("/message/getByUserIdAndNeedToDo/{userId}/{needToDo}")
    List<Message> getByUserIdAndNeedToDo(@RequestParam("userId") Integer userId, @RequestParam("needToDo") Integer needToDo);

    @GetMapping("message/getByUserIdAndOffsetAndPageSize/{userId}/{needToDo}/{offset}/{pageSize}")
    List<Message> getByUserIdAndOffsetAndPageSize(@RequestParam("userId") Integer userId,
                                                  @RequestParam("needToDo") Integer needToDo,
                                                  @RequestParam("offset") Integer offset,
                                                  @RequestParam("pageSize") Integer pageSize);

    @PostMapping("/message")
    boolean insert(Message message);

    @PutMapping("/message/updateAllMessageIsReadByUserId/{userId}/{isRead}")
    boolean updateAllMessageIsReadByUserId(@RequestParam("userId") Integer userId,
                                           @RequestParam("isRead") Integer isRead);

    @GetMapping("/message/{id}")
    Message getById(@RequestParam("id") Integer id);

    @PutMapping("/message")
    boolean update(Message message);

    @PutMapping("/message/updateMessageIsReadByMessageId/{messageId}/{isRead}")
    boolean updateMessageIsReadByMessageId(@RequestParam("messageId") Integer messageId,
                                           @RequestParam("isRead") Integer isRead);

    @GetMapping("/message/getMessageCount/{userId}")
    Integer getMessageCount(@RequestParam("userId") Integer userId);

    @GetMapping("/message/getMessageNeedToDoCount/{userId}")
    Integer getMessageNeedToDoCount(@RequestParam("userId") Integer userId);
}