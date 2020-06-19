package com.edu.lingnan.controller;

import com.edu.lingnan.entity.UserClick;
import com.edu.lingnan.feign.UserClickFeignService;
import com.edu.lingnan.service.UserClickService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserClick)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:18:31
 */
@RestController
@RequestMapping("userClick")
public class UserClickController {
    /**
     * 服务对象
     */
    @Resource
    private UserClickService userClickService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryById")
    public UserClick queryById(Integer id) {
        return this.userClickService.queryById(id);
    }

    /**
     * 插入一条数据
     * @param userClick 更新记录
     * @return Boolean
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Boolean insert(@RequestBody UserClick userClick){
        Boolean flag = userClickService.insert(userClick);
        return flag;
    }
}