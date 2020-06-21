package com.edu.lingnan.controller;

import com.edu.lingnan.feign.ProjectMessageFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 16:39 2020/6/21
 */
@Controller
public class ProjectMessageController {
    @Autowired
    private ProjectMessageFeignService projectMessageFeignService;

    @GetMapping("/projectMessageCount")
    @ResponseBody
    public Integer projectMessageCount(Integer userId, Integer projectId) {
        return projectMessageFeignService.getProjectMessageCount(projectId, userId) + projectMessageFeignService.getProjectMessageNeedToDoCount(projectId);
    }
}
