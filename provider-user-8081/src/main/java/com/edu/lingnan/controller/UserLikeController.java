package com.edu.lingnan.controller;

import com.edu.lingnan.entity.UserLike;
import com.edu.lingnan.entity.UserStore;
import com.edu.lingnan.feign.UserLikeFeignService;
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

    /**
     * 添加点赞
     * @param userLike
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Boolean addUserLike(@RequestBody UserLike userLike){
        return userLikeService.insert(userLike);
    }

    /**
     * 查询项目被点赞数量
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/countLikedNumByProjectId", method = RequestMethod.GET)
    public Integer countLikedNumByProjectId(@RequestParam("projectId") Integer projectId){
        System.out.println("查询项目被点赞数量-->projectId="+projectId);
        Integer num = userLikeService.countLikedNumByProjectId(projectId);
        System.out.println("查询项目被点赞数量-->num="+num);
        return num;
    }

    /**
     * 删除用户点赞
     * @param userId
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/{userId}/{projectId}", method = RequestMethod.DELETE)
    public Boolean deleteUserLike(@PathVariable("userId") Integer userId, @PathVariable("projectId")Integer projectId){
        System.out.println("删除用户点赞-->userId="+userId+" projectId="+projectId);
        Boolean flag = userLikeService.deleteUserLike(userId,projectId);
        System.out.println("删除用户点赞-->结果="+flag);
        return flag;
    }

}