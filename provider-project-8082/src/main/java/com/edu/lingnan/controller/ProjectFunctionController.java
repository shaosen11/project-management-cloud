package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Project;
import com.edu.lingnan.entity.ProjectFunction;
import com.edu.lingnan.feign.ProjectFunctionFeignService;
import com.edu.lingnan.service.ProjectFunctionService;
import com.edu.lingnan.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (ProjectFunction)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:16:42
 */
@RestController
@RequestMapping("projectFunction")
public class ProjectFunctionController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectFunctionService projectFunctionService;

    @Autowired
    private ProjectService projectService;

    /**
     * 通过ID查询单条数据
     *
     * @param projectFunctionId 主键
     * @return 实例对象
     */
    @GetMapping("/{projectFunctionId}")
    public ProjectFunction queryById(@PathVariable("projectFunctionId") Integer projectFunctionId){
        return this.projectFunctionService.queryById(projectFunctionId);
    }

    /**
     * 删除相关的项目功能点信息
     *
     * @param id 主键
     * @return 单条数据
     */
    @DeleteMapping("/deleteProjectFunctionByProjectsId/{id}")
    public Boolean deleteProjectFunctionByProjectsId(@PathVariable("id") Integer id){
        return projectFunctionService.deleteProjectFunctionByProjectsId(id);
    }

    /**
     * 获取功能点页面进度条数据
     * @return Integer
     */
    @RequestMapping(value = "/getProjectFunctionDataCicleChart", method = RequestMethod.GET)
    public Integer getProjectFunctionDataCicleChart(@RequestParam("projectId") Integer projectId) {
        System.out.println("获取功能点页面进度条数据->projectId="+projectId);
        Integer data1 = projectFunctionService.countProjectFunctionByProjectId(projectId);
        if (data1 == 0) {
            return 0;
        } else {
            Integer data2 = projectFunctionService.countByProjectIdAndStatus(projectId, 3);
            Integer data3 = projectFunctionService.countByProjectIdAndStatus(projectId, 4);
            Integer projectFunctionData = ((data2 + data3) * 100) / data1;
            System.out.println("获取功能点页面进度条数据->projectFunctionData="+projectFunctionData);
            return projectFunctionData;
        }
    }

    /**
     * 获取功能点页面各状态的功能点的数量
     * @return Integer
     */
    @RequestMapping(value = "/getProjectFunctionTotal", method = RequestMethod.POST)
    public Map<String, Integer> getProjectFunctionTotal(@RequestParam("projectId") Integer projectId) {
        System.out.println("projectId:"+projectId);
        Integer data0 = projectFunctionService.countByProjectIdAndStatus(projectId, 0);
        Integer data1 = projectFunctionService.countByProjectIdAndStatus(projectId, 1);
        Integer data2 = projectFunctionService.countByProjectIdAndStatus(projectId, 2);
        Integer data3 = projectFunctionService.countByProjectIdAndStatus(projectId, 3);
        Integer data4 = projectFunctionService.countDelByProjectId(projectId);
        Map<String, Integer> map = new HashMap<>();
        map.put("data0", data0);
        map.put("data1", data1);
        map.put("data2", data2);
        map.put("data3", data3);
        map.put("data4", data4);
        System.out.println("获取功能点页面各状态的功能点的数量:"+map);
        return map;
    }

    /**
     * 分页公共方法
     * @return Integer
     */
    public Map<String, Object> functionPageCom(Integer page, Integer count) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 每页显示条数
        int pageSize = 5;
        try {
            // 计算总页数
            int totalPage = count / pageSize;
            // 不满一页的数据按一页计算
            if (count % pageSize != 0) {
                totalPage++;
            }
            // 当页数大于总页数，直接返回
            if (page > totalPage) {
                return null;
            }
            // 计算sql需要的起始索引
            int offset = (page - 1) * pageSize;
            // 封装数据，并返回
            map.put("page", page);
            map.put("pageSize", pageSize);
            map.put("totalPage", totalPage);
            map.put("offset", offset);
            return map;
        } catch (Exception e) {
            System.out.println("获取函数数据失败" + e);
            return map;
        }
    }

    /**
     * 项目功能--全部功能
     * @return ResponseEntity
     */
    @RequestMapping(value = "/allFunctionPage", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> allFunctionPage(@RequestParam("page")Integer page,@RequestBody ProjectFunction projectFunction) {
        System.out.println("项目功能--全部功能-->当前页：" + page + "  当前功能点：" + projectFunction);
        Map<String, Object> map = new HashMap<String, Object>();
        String functionStatus2 = null;
        // 每页显示条数
        int pageSize = 5;
        try {
                // 获取总条目数
                int count = projectFunctionService.queryAll(projectFunction).size();
                map = functionPageCom(page, count);
                int offset = (int) map.get("offset");
                // 根据起始索引和页面大小去查询数据
                List<ProjectFunction> list = projectFunctionService.queryAllByLimit(offset, pageSize, projectFunction);
                // 封装数据，并返回
                map.put("list", list);
                System.out.println("分页map" + map);
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("获取分页数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 项目功能--指派给我的
     * @return ResponseEntity
     */
    @RequestMapping(value = "/assignFunctionPage", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> assignFunctionPage(@RequestParam("page")Integer page,@RequestBody ProjectFunction projectFunction) {
        System.out.println("项目功能--指派给我的::当前页：" + page + "  当前功能点：" + projectFunction);
        Map<String, Object> map = new HashMap<String, Object>();
        // 每页显示条数
        int pageSize = 5;
        try {
            // 获取总条目数
            int count = projectFunctionService.queryAll(projectFunction).size();
            map = functionPageCom(page, count);
            int offset = (int) map.get("offset");
            // 根据起始索引和页面大小去查询数据
            List<ProjectFunction> list = projectFunctionService.queryAllByLimit(offset, pageSize, projectFunction);
            // 封装数据，并返回
            map.put("list", list);
            System.out.println("分页map" + map);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("获取分页数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 项目功能--我发布的
     * @return ResponseEntity
     */
    @RequestMapping(value = "/publishFunctionPage", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> publishFunctionPage(@RequestParam("page")Integer page,@RequestBody ProjectFunction projectFunction) {
        System.out.println("项目功能--我发布的::当前页：" + page + "  当前功能点：" + projectFunction);
        Map<String, Object> map = new HashMap<String, Object>();
        // 每页显示条数
        int pageSize = 5;
        try {
            // 获取总条目数
            int count = projectFunctionService.queryAll(projectFunction).size();
            map = functionPageCom(page, count);
            int offset = (int) map.get("offset");
            // 根据起始索引和页面大小去查询数据
            List<ProjectFunction> list = projectFunctionService.queryAllByLimit(offset, pageSize, projectFunction);
            // 封装数据，并返回
            map.put("list", list);
            System.out.println("分页map" + map);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("获取分页数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 项目功能--我参与的
     * @return ResponseEntity
     */
    @RequestMapping(value = "/joinFunctionPage", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> joinFunctionPage(@RequestParam("page")Integer page,@RequestBody ProjectFunction projectFunction) {
        System.out.println("项目功能--我参与的::当前页：" + page + "  当前功能点：" + projectFunction);
        Map<String, Object> map = new HashMap<String, Object>();
        // 每页显示条数
        int pageSize = 5;
        try {
            //已取消功能点
            if (projectFunction.getFunctionStatus()==4){
                // 获取总条目数
                int count = projectFunctionService.queryDelByUserId(projectFunction).size();
                map = functionPageCom(page, count);
                int offset = (int) map.get("offset");
                // 根据起始索引和页面大小去查询数据
                List<ProjectFunction> list = projectFunctionService.queryDelByLimitByUserId(offset, pageSize, projectFunction);
                // 封装数据，并返回
                map.put("list", list);
            }else{
                // 获取总条目数
                int count = projectFunctionService.queryAllByUserId(projectFunction).size();
                map = functionPageCom(page, count);
                int offset = (int) map.get("offset");
                // 根据起始索引和页面大小去查询数据
                List<ProjectFunction> list = projectFunctionService.queryAllByLimitByUserId(offset, pageSize, projectFunction);
                // 封装数据，并返回
                map.put("list", list);
            }
            System.out.println("分页map" + map);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("获取分页数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * 获取项目的所有功能点计划
     * @return ResponseEntity
     */
    @RequestMapping(value = "/getProjectFunctionPlan", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getProjectFunctionPlan(@RequestParam("page") Integer page, @RequestParam("projectId") Integer projectId) {
        System.out.println("当前页：" + page + "  项目id" + projectId);
        Map<String, Object> map = new HashMap<String, Object>();
        // 每页显示条数
        int pageSize = 5;
        try {
            // 获取总条目数
            int count = projectFunctionService.countProjectFunctionByProjectId(projectId);
            System.out.println("总条目数="+count);
            map = functionPageCom(page, count);
            int offset = (int) map.get("offset");
            System.out.println(offset + "========================");
            // 根据起始索引和页面大小去查询数据
            List<ProjectFunction> list = projectFunctionService.getProjectPlanFunctionsPage(projectId, offset, pageSize);
            System.out.println("分页list" + list);
            // 封装数据，并返回
            map.put("list", list);
            System.out.println("分页map" + map);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("获取分页数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getFunctionByProjectIdAndRealizeUserId",method = RequestMethod.GET)
    public List<ProjectFunction> getFunctionByProjectIdAndRealizeUserId(@RequestParam("projectsId")Integer projectsId, @RequestParam("realizeUserId")Integer realizeUserId, @RequestParam("functionStatus")Integer functionStatus) {
        return projectFunctionService.getFunctionByProjectIdAndRealizeUserId(projectsId, realizeUserId, functionStatus);
    }

    @RequestMapping(value = "/editProjectFunction",method = RequestMethod.POST)
    public ProjectFunction editProjectFunction(@RequestBody ProjectFunction projectFunction) {
        return projectFunctionService.update(projectFunction);
    }
}