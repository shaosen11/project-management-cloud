package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Message;
import com.edu.lingnan.feign.MessageFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * (Message)表控制层
 *
 * @author makejava
 * @since 2020-06-13 09:13:49
 */
@Controller
@RequestMapping("message")
public class MessageController {
    /**
     * 服务对象
     */
    @Autowired
    private MessageFeignService messageFeignService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    @ResponseBody
    public Message selectOne(@PathVariable("id") Integer id) {
        return messageFeignService.queryById(id);
    }

}