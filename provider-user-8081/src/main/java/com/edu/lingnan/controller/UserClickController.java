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
     * 插入一条数据
     *
     * @param userClick 更新记录
     * @return Boolean
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Boolean insert(@RequestBody UserClick userClick) {
        Boolean flag = userClickService.insert(userClick);
        return flag;
    }

    /**
     * 查询一条点击记录
     *
     * @return
     */
    @GetMapping("getUserClickByUserIdAndProjectId/{userId}/{projectId}")
    UserClick getUserClickByUserIdAndProjectId(
            @PathVariable("userId") Integer userId,
            @PathVariable("projectId") Integer projectId) {
        return userClickService.getUserClickByUserIdAndProjectId(userId, projectId);
    }

    /**
     * 删除点击记录
     *
     * @return
     */
    @DeleteMapping("deleteUserClick/{userId}/{projectId}")
    boolean deleteUserClick(
            @PathVariable("userId") Integer userId,
            @PathVariable("projectId") Integer projectId) {
        return userClickService.deleteUserClick(userId, projectId);
    }

    /**
     * 还原点击记录
     *
     * @return
     */
    @PutMapping("reductionUserClick/{userId}/{projectId}")
    boolean reductionUserClick(
            @PathVariable("userId") Integer userId,
            @PathVariable("projectId") Integer projectId) {
        return userClickService.reductionUserClick(userId, projectId);
    }

    /**
     * 查询项目点击次数
     *
     * @return
     */
    @GetMapping("getCountProjectByClick/{projectId}")
    Integer getCountProjectByClick(@PathVariable("projectId") Integer projectId) {
        return userClickService.getCountProjectByClick(projectId);
    }
}