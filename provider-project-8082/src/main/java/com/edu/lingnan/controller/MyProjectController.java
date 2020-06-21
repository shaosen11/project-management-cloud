package com.edu.lingnan.controller;

import com.edu.lingnan.entity.Echarts;
import com.edu.lingnan.entity.MyProject;
import com.edu.lingnan.entity.Myprojects;
import com.edu.lingnan.entity.Project;
import com.edu.lingnan.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("myProject")
public class MyProjectController {
    @Autowired
    private ProjectService projectService;

    public Map<String, Object> functionPageCom(Integer page, Integer count){
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
            if (page > totalPage){
                return null;
            }
            // 计算sql需要的起始索引
            int offset = (page - 1) * pageSize;
            // 封装数据，并返回
            map.put("page", page);
            map.put("pageSize", pageSize);
            map.put("totalPage", totalPage);
            map.put("offset",offset);
            return map;
        } catch (Exception e) {
            System.out.println("获取函数数据失败" + e);
            return map;
        }
    }

    /**
     * 我的全部项目--饼图1
     * @return Echarts
     */
    @PostMapping("/getMyAllProjectData")
    public List<Echarts> getMyAllProjectData(@RequestParam("userId") Integer userId) {
        System.out.println("我的全部项目--饼图1-->user="+userId);
        List<Echarts> list1 = new ArrayList<>();
        Integer num0 = projectService.getMyProjectNumBySchedule(userId,0);
        Integer num1 = projectService.getMyProjectNumBySchedule(userId,1);
        Integer num2 = projectService.getMyProjectNumBySchedule(userId,2);
        Integer num3 = projectService.getMyProjectNumBySchedule(userId,3);
        Integer num4 = projectService.getMyProjectNumBySchedule(userId,4);
        System.out.println("list1:: num0="+num0+" num1="+num1+" num2="+num2+" num3="+num3+" num4="+num4);
        list1.add(new Echarts("待办",num0));
        list1.add(new Echarts("进行中",num1));
        list1.add(new Echarts("已完成",num2));
        list1.add(new Echarts("已验收",num3));
        list1.add(new Echarts("已取消",num4));
        System.out.println("getMyAllProjectData:"+list1);
        return list1;
    }

    /**
     * 我的负责项目--饼图2
     * @return Echarts
     */
    @PostMapping("/getMyChargeProjectData")
    public List<Echarts> getMyChargeProjectData(@RequestParam("userId") Integer userId) {
        List<Echarts> list2 = new ArrayList<>();
        Integer num0 = projectService.getMyChargeProjectNumBySchedule(userId,0);
        Integer num1 = projectService.getMyChargeProjectNumBySchedule(userId,1);
        Integer num2 = projectService.getMyChargeProjectNumBySchedule(userId,2);
        Integer num3 = projectService.getMyChargeProjectNumBySchedule(userId,3);
        Integer num4 = projectService.getMyChargeProjectNumBySchedule(userId,4);
        System.out.println("list2:: num0="+num0+" num1="+num1+" num2="+num2+" num3="+num3+" num4="+num4);
        list2.add(new Echarts("待办",num0));
        list2.add(new Echarts("进行中",num1));
        list2.add(new Echarts("已完成",num2));
        list2.add(new Echarts("已验收",num3));
        list2.add(new Echarts("已取消",num4));
        System.out.println("getMyChargeProjectData:"+list2);
        return list2;
    }


    /**
     * 我的参与项目--饼图3
     * @return Echarts
     */
    @PostMapping("/getMyJoinProjectData")
    public List<Echarts> getMyJoinProjectData(@RequestParam("userId") Integer userId) {
        List<Echarts> list3 = new ArrayList<>();
        Integer num0 = projectService.getMyJoinProjectNumBySchedule(userId,0);
        Integer num1 = projectService.getMyJoinProjectNumBySchedule(userId,1);
        Integer num2 = projectService.getMyJoinProjectNumBySchedule(userId,2);
        Integer num3 = projectService.getMyJoinProjectNumBySchedule(userId,3);
        Integer num4 = projectService.getMyJoinProjectNumBySchedule(userId,4);
        System.out.println("list3:: num0="+num0+" num1="+num1+" num2="+num2+" num3="+num3+" num4="+num4);
        list3.add(new Echarts("待办",num0));
        list3.add(new Echarts("进行中",num1));
        list3.add(new Echarts("已完成",num2));
        list3.add(new Echarts("已验收",num3));
        list3.add(new Echarts("已取消",num4));
        System.out.println("getMyJoinProjectData::"+list3);
        return list3;
    }

    /**
     * 我的项目
     * @return ResponseEntity
     */
    @RequestMapping(value = "/getMyProjectPageByStatus", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getMyProjectPageByStatus(@RequestParam("page") Integer page, @RequestParam("userId")Integer userId,@RequestParam("status")Integer status){
        System.out.println("当前页：" + page+"  当前用户：" + userId+" 状态="+status);
        Map<String, Object> map = new HashMap<String, Object>();
        // 每页显示条数
        int pageSize = 5;
        try {
            // 我的全部项目
            if (status==1){
                int count = projectService.getMyAllProjectNum(userId);
                System.out.println("userid:"+userId+" 我的项目数目："+count);
                map = functionPageCom(page,count);
                int offset = (int) map.get("offset");
                // 根据起始索引和页面大小去查询数据
                List<MyProject> list = projectService.getMyAllProjectPage(userId,offset,pageSize);
                System.out.println("分页list"+list);
                // 封装数据，并返回
                map.put("list", list);
            }else if(status == 2){
                //我负责的项目
                int count = projectService.getMyChargeProjectNum(userId);
                System.out.println("userid:"+userId+" 我负责的项目数目："+count);
                map = functionPageCom(page,count);
                int offset = (int) map.get("offset");
                // 根据起始索引和页面大小去查询数据
                List<MyProject> list  = projectService.getMyChargeProjectPage(userId,offset,pageSize);
                System.out.println("分页list"+list);
                // 封装数据，并返回
                map.put("list", list);
            }else if(status == 3){
                //我参加的项目
                int count = projectService.getMyJoinProjectNum(userId);
                System.out.println("userid:"+userId+" 我负责的项目数目："+count);
                map = functionPageCom(page,count);
                int offset = (int) map.get("offset");
                // 根据起始索引和页面大小去查询数据
                List<MyProject> list = projectService.getMyJoinProjectPage(userId,offset,pageSize);
                System.out.println("分页list"+list);
                // 封装数据，并返回
                map.put("list", list);
            }
            System.out.println("分页map"+map);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("获取分页数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 我的项目--按类型和进度搜索
     * @return
     */
    @RequestMapping(value = "/getMyProjectByTypeOrSchedule", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getMyProjectByTypeOrSchedule(@RequestParam("page")Integer page, @RequestParam("typeId")Integer typeId, @RequestParam("scheduleId")Integer scheduleId,@RequestParam("status")Integer status){
        System.out.println("当前页：" +page+"  type="+typeId+" schedule="+scheduleId);
        Map<String, Object> map = new HashMap<String, Object>();
        // 每页显示条数
        int pageSize = 5;
        MyProject myProject = new MyProject();
        if(typeId == 0){
            myProject.setTypeId(null);
        }else{
            myProject.setTypeId(typeId);
        }
        if(scheduleId == 0){
            myProject.setScheduleId(null);
        }else{
            myProject.setScheduleId(scheduleId);
        }
        List<MyProject > list = null;
        int count = 0;
        try {
            // 我的全部项目
            if (status==1){
                count = projectService.queryMyProjectByTypeOrSchedule(myProject,16).size();
                System.out.println("按类型和进度搜索--我的项目数目："+count);
                map = functionPageCom(page,count);
                int offset = (int) map.get("offset");
                // 根据起始索引和页面大小去查询数据
                list = projectService.queryMyProjectPageByTypeOrSchedule(offset,pageSize,myProject,16);
                System.out.println("按类型和进度搜索--分页list"+list);
                // 封装数据，并返回
                map.put("list", list);
            }else if(status == 2){
                //我负责的项目
                myProject.setChargeUserId(16);
                count = projectService.queryMyProjectByTypeOrSchedule(myProject,16).size();
                System.out.println("我负责的项目数目："+count);
                map = functionPageCom(page,count);
                int offset = (int) map.get("offset");
                // 根据起始索引和页面大小去查询数据
                list = projectService.queryMyProjectPageByTypeOrSchedule(offset,pageSize,myProject,16);
                System.out.println("按类型和进度搜索--我负责的项目分页list"+list);
                // 封装数据，并返回
                map.put("list", list);
            }else if(status == 3){
                //我参加的项目
                myProject.setChargeUserId(16);
                count = projectService.queryMyProjectByTypeOrSchedule2(myProject,16).size();
                System.out.println("我参加的项目数目："+count);
                map = functionPageCom(page,count);
                int offset = (int) map.get("offset");
                // 根据起始索引和页面大小去查询数据
                list = projectService.queryMyProjectPageByTypeOrSchedule2(offset,pageSize,myProject,16);
                System.out.println("按类型和进度搜索--我参加的项目分页list"+list);
                // 封装数据，并返回
                map.put("list", list);
            }
            // 封装数据，并返回
            map.put("list", list);
            System.out.println("分页map"+map);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("获取分页数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //我的项目--模糊搜索
    @RequestMapping(value = "/getMyProjectByFuzzySearch", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getMyProjectByFuzzySearch(@RequestParam("page")Integer page, @RequestParam("content")String content,@RequestParam("status")Integer status){
        System.out.println("当前页：" +page+"  content："+content+"  status：" + status);
        Map<String, Object> map = new HashMap<String, Object>();
        // 每页显示条数
        int pageSize = 5;
        Integer userId = 16;
        int count=0;
        List<MyProject> list = null;
        try {
            // 获取总条目数
            if(content != null){
                // 我的全部项目
                if (status==1){
                    count = projectService.queryMyProjectByFuzzySearch(content,userId,0).size();
                    System.out.println("userid:"+userId+" 我的项目数目："+count);
                    map = functionPageCom(page,count);
                    int offset = (int) map.get("offset");
                    // 根据起始索引和页面大小去查询数据
                    list = projectService.queryMyProjectPageByFuzzySearch(offset,pageSize,content,userId,0);
                    System.out.println("分页list"+list);
                    // 封装数据，并返回
                    map.put("list", list);
                }else if(status == 2){
                    //我负责的项目
                    count = projectService.queryMyProjectByFuzzySearch(content,userId,userId).size();
                    System.out.println("userid:"+userId+" 我负责的项目数目："+count);
                    map = functionPageCom(page,count);
                    int offset = (int) map.get("offset");
                    // 根据起始索引和页面大小去查询数据
                    list = projectService.queryMyProjectPageByFuzzySearch(offset,pageSize,content,userId,userId);
                    System.out.println("分页list"+list);
                    // 封装数据，并返回
                    map.put("list", list);
                }else if(status == 3){
                    //我参加的项目
                    count = projectService.queryMyProjectByFuzzySearch2(content,userId,userId).size();
                    System.out.println("userid:"+userId+" 我负责的项目数目："+count);
                    map = functionPageCom(page,count);
                    int offset = (int) map.get("offset");
                    // 根据起始索引和页面大小去查询数据
                    list = projectService.queryMyProjectPageByFuzzySearch2(offset,pageSize,content,userId,userId);
                    System.out.println("分页list"+list);
                    // 封装数据，并返回
                    map.put("list", list);
                }
            }else{
                // 我的全部项目
                if (status==1){
                    count = projectService.getMyAllProjectNum(userId);
                    System.out.println("userid:"+userId+" 我的项目数目："+count);
                    map = functionPageCom(page,count);
                    int offset = (int) map.get("offset");
                    // 根据起始索引和页面大小去查询数据
                    list = projectService.getMyAllProjectPage(userId,offset,pageSize);
                    System.out.println("分页list"+list);
                    // 封装数据，并返回
                    map.put("list", list);
                }else if(status == 2){
                    //我负责的项目
                    count = projectService.getMyChargeProjectNum(userId);
                    System.out.println("userid:"+userId+" 我负责的项目数目："+count);
                    map = functionPageCom(page,count);
                    int offset = (int) map.get("offset");
                    // 根据起始索引和页面大小去查询数据
                    list  = projectService.getMyChargeProjectPage(userId,offset,pageSize);
                    System.out.println("分页list"+list);
                    // 封装数据，并返回
                    map.put("list", list);
                }else if(status == 3){
                    //我参加的项目
                    count = projectService.getMyJoinProjectNum(userId);
                    System.out.println("userid:"+userId+" 我负责的项目数目："+count);
                    map = functionPageCom(page,count);
                    int offset = (int) map.get("offset");
                    // 根据起始索引和页面大小去查询数据
                    list = projectService.getMyJoinProjectPage(userId,offset,pageSize);
                    System.out.println("分页list"+list);
                    // 封装数据，并返回
                    map.put("list", list);
                }
            }
            System.out.println("分页list"+list);
            // 封装数据，并返回
            map.put("list", list);
            System.out.println("分页map"+map);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("获取分页数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 查看我的项目收藏
     * @return
     */
    @RequestMapping(value = "/getMyProjectStore", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> myProjectsStore(@RequestParam("page")Integer page,@RequestParam("userId")Integer userId){
        System.out.println("我的项目收藏当前页：" + page+"  当前用户：" + userId);
        Map<String, Object> map = new HashMap<String, Object>();
        // 每页显示条数
        int pageSize = 5;
        try {
            // 获取总条目数
            int count = projectService.getMyProjectStoreNumByUserId(userId);
            map = functionPageCom(page,count);
            int offset = (int) map.get("offset");
            // 根据起始索引和页面大小去查询数据
            List<MyProject> list = projectService.getMyProjectStorePageByUserId(userId,offset,pageSize);
            System.out.println("分页list"+list);
            // 封装数据，并返回
            map.put("list", list);
            System.out.println("分页map"+map);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("获取分页数据失败" + e);
            return new ResponseEntity<Map<String, Object>>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
