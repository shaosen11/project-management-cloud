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
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("userClick/queryById")
    UserClick queryById(Integer id);

    /**
     * 插入一条数据
     * @param userClick 更新记录
     * @return Boolean
     */
    @RequestMapping(value = "userClick/", method = RequestMethod.POST, consumes = "application/json")
    Boolean insert(@RequestBody UserClick userClick);

}