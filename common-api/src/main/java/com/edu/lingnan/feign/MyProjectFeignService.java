package com.edu.lingnan.feign;

import com.edu.lingnan.entity.Echarts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 10314
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface MyProjectFeignService {
    /**
     * 我的全部项目--饼图1
     * @return Echarts
     */
    @PostMapping("myProject/getMyAllProjectData")
    List<Echarts> getMyAllProjectData();

    /**
     * 我的负责项目--饼图2
     * @return Echarts
     */
    @PostMapping("myProject/getMyChargeProjectData")
    List<Echarts> getMyChargeProjectData();


    /**
     * 我的参与项目--饼图3
     * @return Echarts
     */
    @PostMapping("myProject/getMyJoinProjectData")
    List<Echarts> getMyJoinProjectData();

    /**
     * 我的项目
     * @return ResponseEntity
     */
    @RequestMapping(value = "myProject/getMyProjectPageByStatus", method = RequestMethod.GET)
    ResponseEntity<Map<String, Object>> getMyProjectPageByStatus(@RequestParam("page") Integer page, @RequestParam("userId")Integer userId, @RequestParam("status")Integer status);

    /**
     * 我的项目--按类型和进度搜索
     * @return
     */
    @RequestMapping(value = "myProject/getMyProjectByTypeOrSchedule", method = RequestMethod.GET)
    ResponseEntity<Map<String, Object>> getMyProjectByTypeOrSchedule(@RequestParam("page")Integer page, @RequestParam("typeId")Integer typeId, @RequestParam("scheduleId")Integer scheduleId,@RequestParam("status")Integer status);

    /**
     * 我的项目--模糊搜索
     * @return
     */
    @RequestMapping(value = "myProject/getMyProjectByFuzzySearch", method = RequestMethod.GET)
    ResponseEntity<Map<String, Object>> getMyProjectByFuzzySearch(@RequestParam("page")Integer page, @RequestParam("content")String content,@RequestParam("status")Integer status);

    /**
     * 查看我的项目收藏
     * @return
     */
    @RequestMapping(value = "myProject/getMyProjectStore", method = RequestMethod.GET)
    ResponseEntity<Map<String, Object>> myProjectsStore(@RequestParam("page")Integer page,@RequestParam("userId")Integer userId);


}
