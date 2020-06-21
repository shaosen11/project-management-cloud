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

    /**
     * 添加收藏
     * @param userStore
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Boolean addUserStore(@RequestBody UserStore userStore){
        return userStoreService.insert(userStore);
    }

    /**
     * 查询项目被收藏数量
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/countStoredNumByProjectId", method = RequestMethod.GET)
    public Integer countStoredNumByProjectId(@RequestParam("projectId") Integer projectId){
        System.out.println("查询项目被收藏数量-->projectId="+projectId);
        Integer num = userStoreService.countStoredNumByProjectId(projectId);
        System.out.println("查询项目被收藏数量-->num="+num);
        return num;
    }

    /**
     * 删除用户收藏
     * @param userId
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/{userId}/{projectId}", method = RequestMethod.DELETE)
    public Boolean deleteUserStore(@PathVariable("userId") Integer userId, @PathVariable("projectId")Integer projectId){
        System.out.println("删除用户收藏-->userId="+userId+" projectId="+projectId);
        Boolean flag = userStoreService.deleteUserStore(userId,projectId);
        System.out.println("删除用户收藏-->结果="+flag);
        return flag;
    }

}