package com.edu.lingnan.feign;

import com.edu.lingnan.entity.ProjectFunction;
import com.edu.lingnan.entity.ProjectUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (ProjectUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:14:09
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface ProjectUserFeignService {

    @DeleteMapping("projectUser/deleteProjectUserByProjectsId/{id}")
    Boolean deleteProjectUserByProjectsId(@PathVariable("id") Integer id);

    /**
     * 通过ID查询单条数据
     * @return 实例对象
     */
    @RequestMapping(value = "projectUser/getByUserIdAndProjectId", method = RequestMethod.GET)
    ProjectUser getByUserIdAndProjectId(@RequestParam("userId") Integer userId, @RequestParam("projectId")Integer projectId);

}