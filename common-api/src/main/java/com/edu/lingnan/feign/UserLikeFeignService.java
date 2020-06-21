package com.edu.lingnan.feign;

import com.edu.lingnan.entity.UserLike;
import com.edu.lingnan.entity.UserStore;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (UserLike)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:15:04
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface UserLikeFeignService {

    /**
     * 添加点赞
     * @param userLike
     * @return
     */
    @RequestMapping(value = "userLike/", method = RequestMethod.POST,consumes = "application/json" )
    Boolean addUserLike(@RequestBody UserLike userLike);

    /**
     * 查询项目被点赞数量
     * @param projectId
     * @return
     */
    @RequestMapping(value = "userLike/countLikedNumByProjectId", method = RequestMethod.GET)
    Integer countLikedNumByProjectId(@RequestParam("projectId") Integer projectId);

    /**
     * 删除用户点赞
     * @param userId
     * @param projectId
     * @return
     */
    @RequestMapping(value = "userLike/{userId}/{projectId}", method = RequestMethod.DELETE)
    Boolean deleteUserLike(@PathVariable("userId") Integer userId, @PathVariable("projectId")Integer projectId);

}