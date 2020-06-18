package com.edu.lingnan.feign;

import com.edu.lingnan.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @GetMapping("project/{id}")
    Project queryById(@PathVariable("id") Integer id);

    /**
     * 查询所有项目信息
     * @return 数据
     */
    @GetMapping("project/queryAll")
    List<Project> queryAll();

    /**
     * 记录项目点击量
     * @return 数据
     */
    @RequestMapping(value = "project/updateProjectClickCountById", method = RequestMethod.PUT, consumes = "application/json")
    Boolean updateProjectClickCountById(@RequestBody Integer projectId);

    /**
     * 添加项目
     * @return 数据
     */
    @RequestMapping(value = "project/", method = RequestMethod.POST, consumes = "application/json")
    Boolean addProject(@RequestBody Project project);

    /**
     * 删除项目
     * @return 数据
     */
    @DeleteMapping("project/{id}")
    Boolean deleteProject(@PathVariable("id") Integer id) ;

    /**
     * 修改项目信息
     * @return 数据
     */
    @RequestMapping(value = "project/", method = RequestMethod.PUT, consumes = "application/json")
    Boolean updateProject(@RequestBody Project project);

    /**
     * 查询所有注销项目信息
     * @return 数据
     */
    @GetMapping("project/getDeletedProject")
    List<Project> getDeletedProject();

    /**
     * 还原用户项目
     * @return 数据
     */
    @RequestMapping(value = "project/updateDelProjectById", method = RequestMethod.PUT,consumes = "application/json")
    Boolean updateDelProjectById(@RequestBody Integer id);

}