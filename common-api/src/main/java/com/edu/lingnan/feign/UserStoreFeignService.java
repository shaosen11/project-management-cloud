package com.edu.lingnan.feign;

import com.edu.lingnan.entity.UserStore;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (UserStore)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:15:15
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface UserStoreFeignService {

    /**
     * 添加收藏
     * @param userStore
     * @return
     */
    @RequestMapping(value = "userStore/", method = RequestMethod.POST,consumes = "application/json" )
    Boolean addUserStore(@RequestBody UserStore userStore);

    /**
     * 查询项目被收藏数量
     * @param projectId
     * @return
     */
    @RequestMapping(value = "userStore/countStoredNumByProjectId", method = RequestMethod.GET)
    Integer countStoredNumByProjectId(@RequestParam("projectId") Integer projectId);

    /**
     * 删除用户收藏
     * @param userId
     * @param projectId
     * @return
     */
    @RequestMapping(value = "userStore/{userId}/{projectId}", method = RequestMethod.DELETE)
    Boolean deleteUserStore(@PathVariable("userId") Integer userId, @PathVariable("projectId")Integer projectId);

}