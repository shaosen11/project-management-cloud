package com.edu.lingnan.controller;

import com.edu.lingnan.entity.UserStore;
import com.edu.lingnan.feign.UserStoreFeignService;
import com.edu.lingnan.service.UserStoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserStore)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:19:11
 */
@RestController
@RequestMapping("userStore")
public class UserStoreController {
    /**
     * 服务对象
     */
    @Resource
    private UserStoreService userStoreService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserStore selectOne(Integer id) {
        return this.userStoreService.queryById(id);
    }

}