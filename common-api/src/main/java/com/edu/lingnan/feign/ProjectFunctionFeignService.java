package com.edu.lingnan.feign;

import com.edu.lingnan.entity.Project;
import com.edu.lingnan.entity.ProjectFunction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * (ProjectFunction)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:13:23
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface ProjectFunctionFeignService {

    /**
     * 删除相关的项目功能点信息
     * @param id
     * @return
     */
    @DeleteMapping("projectFunction/deleteProjectFunctionByProjectsId/{id}")
    Boolean deleteProjectFunctionByProjectsId(@PathVariable("id") Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param projectFunctionId 主键
     * @return 实例对象
     */
    @GetMapping("projectFunction/{projectFunctionId}")
    ProjectFunction queryById(@PathVariable("projectFunctionId") Integer projectFunctionId);

    /**
     * 获取功能点页面进度条数据
     * @return Integer
     */
    @RequestMapping(value = "projectFunction/getProjectFunctionDataCicleChart", method = RequestMethod.GET)
    Integer getProjectFunctionDataCicleChart(@RequestParam("projectId") Integer projectId);

    /**
     * 获取功能点页面各状态的功能点的数量
     * @return Integer
     */
    @RequestMapping(value = "projectFunction/getProjectFunctionTotal", method = RequestMethod.POST)
    Map<String, Integer> getProjectFunctionTotal(@RequestParam("projectId") Integer projectId);

    /**
     * 项目功能--全部功能
     * @return ResponseEntity
     */
    @RequestMapping(value = "projectFunction/allFunctionPage", method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<Map<String, Object>> allFunctionPage(@RequestParam("page")Integer page,@RequestBody ProjectFunction projectFunction);

    /**
     * 项目功能--指派给我的
     * @return ResponseEntity
     */
    @RequestMapping(value = "projectFunction/assignFunctionPage", method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<Map<String, Object>> assignFunctionPage(@RequestParam("page")Integer page,@RequestBody ProjectFunction projectFunction);

    /**
     * 项目功能--我发布的
     * @return ResponseEntity
     */
    @RequestMapping(value = "projectFunction/publishFunctionPage", method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<Map<String, Object>> publishFunctionPage(@RequestParam("page")Integer page,@RequestBody ProjectFunction projectFunction);

    /**
     * 项目功能--我参与的
     * @return ResponseEntity
     */
    @RequestMapping(value = "projectFunction/joinFunctionPage", method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<Map<String, Object>> joinFunctionPage(@RequestParam("page")Integer page,@RequestBody ProjectFunction projectFunction);

    /**
     * 获取项目的所有功能点计划
     * @return ResponseEntity
     */
    @RequestMapping(value = "projectFunction/getProjectFunctionPlan", method = RequestMethod.GET)
    ResponseEntity<Map<String, Object>> getProjectFunctionPlan(@RequestParam("page") Integer page, @RequestParam("projectId") Integer projectId);


}