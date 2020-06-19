package com.edu.lingnan.feign;

import com.edu.lingnan.entity.UserClick;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (UserClick)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:14:52
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface UserClickFeignService {

    /**
     * 插入一条数据
     *
     * @param userClick 更新记录
     * @return Boolean
     */
    @RequestMapping(value = "userClick/", method = RequestMethod.POST, consumes = "application/json")
    Boolean insert(@RequestBody UserClick userClick);

    /**
     * 查询一条点击记录
     *
     * @return
     */
    @GetMapping("userClick/getUserClickByUserIdAndProjectId/{userId}/{projectId}")
    UserClick getUserClickByUserIdAndProjectId(
            @RequestParam("userId") Integer userId,
            @RequestParam("projectId") Integer projectId);

    /**
     * 删除点击记录
     *
     * @return
     */
    @DeleteMapping("userClick/deleteUserClick/{userId}/{projectId}")
    boolean deleteUserClick(
            @RequestParam("userId") Integer userId,
            @RequestParam("projectId") Integer projectId);

    /**
     * 还原点击记录
     *
     * @return
     */
    @PutMapping("userClick/reductionUserClick/{userId}/{projectId}")
    boolean reductionUserClick(
            @RequestParam("userId") Integer userId,
            @RequestParam("projectId") Integer projectId);

    /**
     * 查询项目点击次数
     *
     * @return
     */
    @GetMapping("userClick/getCountProjectByClick/{projectId}")
    Integer getCountProjectByClick(@RequestParam("projectId") Integer projectId);

}