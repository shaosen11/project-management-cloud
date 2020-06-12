package com.edu.lingnan.controller;

import com.edu.lingnan.entity.UserLike;
import com.edu.lingnan.service.UserLikeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserLike)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:18:50
 */
@RestController
@RequestMapping("userLike")
public class UserLikeController {
    /**
     * 服务对象
     */
    @Resource
    private UserLikeService userLikeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserLike selectOne(Integer id) {
        return this.userLikeService.queryById(id);
    }

}