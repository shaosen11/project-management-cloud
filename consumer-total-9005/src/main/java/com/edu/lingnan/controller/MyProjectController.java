package com.edu.lingnan.controller;

import com.edu.lingnan.entity.*;
import com.edu.lingnan.feign.MyProjectFeignService;
import com.edu.lingnan.feign.ProjectFeignService;
import com.edu.lingnan.feign.UserLikeFeignService;
import com.edu.lingnan.feign.UserStoreFeignService;
import com.edu.lingnan.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 10314
 */
@Controller
public class MyProjectController {

    @Autowired
    private MyProjectFeignService myProjectFeignService;

    @Autowired
    private UserStoreFeignService userStoreFeignService;

    @Autowired
    private UserLikeFeignService userLikeFeignService;

    @Autowired
    private ProjectFeignService projectFeignService;

    /**
     * 查看我的项目
     * @param id 项目id
     * @return String
     */
    @GetMapping("/my_projects/{id}")
    public String myProjects(@PathVariable("id")Integer id){
        return "myprojects";
    }

    /**
     * 我的项目--饼图1
     * @return Echarts
     */
    @PostMapping("/getMyAllProjectData")
    @ResponseBody
    public List<Echarts> getMyAllProjectData(HttpServletRequest request) {
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        System.out.println("用户session="+user);
        List<Echarts> list = myProjectFeignService.getMyAllProjectData(user.getId());
        System.out.println("getMyAllProjectData:"+list);
        return list;
    }

    /**
     * 我的负责项目--饼图2
     * @return Echarts
     */
    @PostMapping("/getMyChargeProjectData")
    @ResponseBody
    public List<Echarts> getMyChargeProjectData(HttpServletRequest request) {
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        List<Echarts> list = myProjectFeignService.getMyChargeProjectData(user.getId());
        System.out.println("getMyChargeProjectNumBySchedule:"+list);
        return list;
    }

    /**
     * 我的参与项目--饼图3
     * @return Echarts
     */
    @PostMapping("/getMyJoinProjectData")
    @ResponseBody
    public List<Echarts> getMyJoinProjectData(HttpServletRequest request) {
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        List<Echarts> list = myProjectFeignService.getMyJoinProjectData(user.getId());
        System.out.println("getMyJoinProjectNumBySchedule:"+list);
        return list;
    }

    /**
     * 我的项目
     * @return ResponseEntity
     */
    @GetMapping("/getMyProjectPageByStatus")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getMyProjectPageByStatus(Integer page,Integer status,HttpServletRequest request) {
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        System.out.println("当前页：" + page + " 状态=" + status);
        ResponseEntity<Map<String, Object>> list = myProjectFeignService.getMyProjectPageByStatus(page,user.getId(),status);
        System.out.println("我的项目-->status="+status+" list="+list);
        return list;
    }


    /**
     * 我的项目--收藏
     * @return ResponseEntity
     */
    @ResponseBody
    @GetMapping("/myProjectAddStore")
    public ResponseEntity<Map<String, Object>> myProjectsRefrech(Integer projectId,Integer page,Integer status,HttpServletRequest request){
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        System.out.println("收藏项目:"+" projectId="+projectId+" page="+page+" status="+status);
        UserStore userStore = new UserStore();
        userStore.setUserId(user.getId());
        userStore.setProjectsId(projectId);
        Boolean flag = userStoreFeignService.addUserStore(userStore);
        System.out.println("添加UserStore"+userStore+" 结果="+flag);
        Integer storenum = userStoreFeignService.countStoredNumByProjectId(projectId);
        Project project = projectFeignService.getById(projectId);
        project.setStoreCount(storenum);
        System.out.println("收藏数="+storenum+" 收藏项目"+project);
        projectFeignService.updateProject(project);
        ResponseEntity<Map<String, Object>> list = myProjectFeignService.getMyProjectPageByStatus(page,user.getId(),status);
        System.out.println("收藏项目,返回："+list);
        return list;
    }

    /**
     * 我的项目--取消收藏
     * @return ResponseEntity
     */
    @ResponseBody
    @GetMapping("/myProjectDelStore")
    public ResponseEntity<Map<String, Object>> myProjectsDelRefrech(Integer projectId,Integer page,Integer status,HttpServletRequest request){
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        System.out.println("取消收藏项目:"+" projectId="+projectId+" page="+page+" status="+status);
        userStoreFeignService.deleteUserStore(user.getId(),projectId);
        Integer storenum = userStoreFeignService.countStoredNumByProjectId(projectId);
        Project projects = projectFeignService.getById(projectId);
        projects.setStoreCount(storenum);
        System.out.println("取消收藏项目"+projects);
        projectFeignService.updateProject(projects);
        ResponseEntity<Map<String, Object>> list = myProjectFeignService.getMyProjectPageByStatus(page,user.getId(),status);
        System.out.println("取消收藏项目,返回："+list);
        return list;
    }

    /**
     * 我的项目--点赞
     * @param projectId
     * @param page
     * @param status
     * @return ResponseEntity
     */
    @ResponseBody
    @GetMapping("/myProjectAddLike")
    public ResponseEntity<Map<String, Object>>  myProjectAddLike(Integer projectId,Integer page,Integer status,HttpServletRequest request){
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        System.out.println("点赞项目:"+" projectId="+projectId+" page="+page+" status="+status);
        UserLike userLike = new UserLike();
        userLike.setUserId(user.getId());
        userLike.setProjectId(projectId);
        System.out.println("添加userLike="+userLike);
        userLikeFeignService.addUserLike(userLike);
        Integer num = userLikeFeignService.countLikedNumByProjectId(projectId);
        Project projects = projectFeignService.getById(projectId);
        projects.setLikeCount(num);
        System.out.println("点赞项目"+projects);
        projectFeignService.updateProject(projects);
        ResponseEntity<Map<String, Object>> list = myProjectFeignService.getMyProjectPageByStatus(page,user.getId(),status);
        System.out.println("点赞项目,返回："+list);
        return list;
    }

    /**
     * 我的项目--取消点赞
     * @param projectId
     * @param page
     * @param status
     * @return
     */
    @ResponseBody
    @GetMapping("/myProjectDelLike")
    public ResponseEntity<Map<String, Object>> myProjectDelLike(Integer projectId,Integer page,Integer status,HttpServletRequest request){
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        System.out.println("取消点赞:"+" projectId="+projectId+" page="+page+" status="+status);
        userLikeFeignService.deleteUserLike(user.getId(),projectId);
        Integer likenum = userLikeFeignService.countLikedNumByProjectId(projectId);
        Project projects = projectFeignService.getById(projectId);
        projects.setLikeCount(likenum);
        System.out.println("取消点赞项目"+projects);
        projectFeignService.updateProject(projects);
        ResponseEntity<Map<String, Object>> list = myProjectFeignService.getMyProjectPageByStatus(page,user.getId(),status);
        System.out.println("取消点赞项目,返回："+list);
        return list;
    }

    /**
     * 我的项目--按类型和进度搜索
     * @return
     */
    @GetMapping("/getMyProjectByTypeOrSchedule")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getMyProjectByTypeOrSchedule(Integer page, Integer typeId, Integer scheduleId,Integer status){
        System.out.println("当前页：" +page+"  type="+typeId+" schedule="+scheduleId+" status="+status);
        ResponseEntity<Map<String, Object>> map = myProjectFeignService.getMyProjectByTypeOrSchedule(page,typeId,scheduleId,status);
        System.out.println("我的项目--按类型和进度搜索-->map="+map);
        return map;
    }

    /**
     * 我的项目--模糊搜索
     * @return
     */
    @GetMapping("/getMyProjectByFuzzySearch")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getMyProjectByFuzzySearch(Integer page,String content,Integer status){
        System.out.println("当前页：" +page+"  content=："+content+" status="+status);
        ResponseEntity<Map<String, Object>> map = myProjectFeignService.getMyProjectByFuzzySearch(page,content,status);
        System.out.println("我的项目--模糊搜索-->map="+map);
        return map;
    }

    /**
     * 查看我的项目收藏页面
     * @return
     */
    @GetMapping("/my_projects_store/{id}")
    public String toMyProjectStore(@PathVariable("id")Integer id){
        return "mystore";
    }

    /**
     * 查看我的项目收藏
     * @return
     */
    @GetMapping("/getMyProjectStore")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> myProjectsStore(Integer page,HttpServletRequest request){
        MyUserDetails user = UserUtil.getMyUserDetailsBySecurity(request);
        Integer userId = user.getId();
        ResponseEntity<Map<String, Object>> map = myProjectFeignService.myProjectsStore(page,userId);
        System.out.println("查看我的项目收藏-->map="+map);
        return map;
    }
}
