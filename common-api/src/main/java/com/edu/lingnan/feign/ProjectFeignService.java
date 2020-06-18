package com.edu.lingnan.feign;

import com.edu.lingnan.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * (Project)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:12:40
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface ProjectFeignService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping("project/get/{id}")
    Project queryById(@PathVariable("id") Integer id);

    /**
     * 统计系统项目数量
     * @return
     */
    @GetMapping("project/getProjectCount")
    Integer getProjectCount();

}