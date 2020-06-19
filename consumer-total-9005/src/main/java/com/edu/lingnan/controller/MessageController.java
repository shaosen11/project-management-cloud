package com.edu.lingnan.controller;

import com.edu.lingnan.entity.*;
import com.edu.lingnan.exception.AJaxResponse;
import com.edu.lingnan.exception.CustomException;
import com.edu.lingnan.exception.CustomExceptionType;
import com.edu.lingnan.feign.*;
import com.edu.lingnan.utils.DateFromatUtil;
import com.edu.lingnan.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 21:32 2020/4/11
 */
@Controller
public class MessageController {
    @Autowired
    MessageFeignService messageFeignService;

    @Autowired
    MessageNeedToDoRelationshipFeignService messageNeedToDoRelationshipFeignService;

    @Autowired
    ProjectUserCooperationFeignService projectUserCooperationFeignService;

    @Autowired
    ProjectUserFeignService projectUserFeignService;

    @Autowired
    ProjectMessageFeignService projectMessageFeignService;

    @Autowired
    SysUserFeignService sysUserFeignService;

    @Autowired
    ProjectFeignService projectFeignService;

    @PostMapping("/myMessage")
    @ResponseBody
    public List<Message> myMessgae(Integer userId, Integer needToDo) {
        List<Message> messageList = messageFeignService.getByUserIdAndNeedToDo(userId, needToDo);
        return messageList;
    }

    @GetMapping("/updateAllMessageIsReadByUserId")
    @ResponseBody
    public AJaxResponse updateAllMessageIsReadByUserId(Integer userId) {
        boolean result = messageFeignService.updateAllMessageIsReadByUserId(userId, 0);
        if (result) {
            return AJaxResponse.success("标志所有消息已读");
        } else {
            return AJaxResponse.error(new CustomException(CustomExceptionType.SYSTEM_ERROR, "标志所有消息已读操作失败"));
        }
    }

    @GetMapping("/updateMessageIsReadByMessageId")
    @ResponseBody
    public AJaxResponse updateMessageIsReadByMessageId(Integer messageId) {
        messageFeignService.updateMessageIsReadByMessageId(messageId, 0);
        return AJaxResponse.success("标志消息已读");
    }

    @PutMapping("/agreeNeedToDo")
    @ResponseBody
    public AJaxResponse agreeNeedToDo(Integer messageId) {
        //通过messageId查找待办的事件
        MessageNeedToDoRelationship messageNeedToDoRelationship = messageNeedToDoRelationshipFeignService.getByMessageId(messageId);
        //如果是项目邀请
        if (messageNeedToDoRelationship.getProjectsUserCooperrationId() != 0) {
            ProjectUserCooperation projectsUserCooperation = projectUserCooperationFeignService.getById(messageNeedToDoRelationship.getProjectsUserCooperrationId());
            //获取邀请信息对应的项目，和被邀请人
            Integer inProjectUserId = projectsUserCooperation.getInProjectUserId();
            Integer notInProjectUserId = projectsUserCooperation.getNotInProjectUserId();
            Integer projectId = projectsUserCooperation.getProjectsId();
            Integer dutyCode = projectsUserCooperation.getDutyCode();
            //加入projectuser表
            ProjectUser projectsUser = new ProjectUser();
            projectsUser.setProjectId(projectId);
            projectsUser.setUserId(notInProjectUserId);
            projectsUser.setDutyCode(dutyCode);
            projectsUser.setJoinTime(new Date());
            projectUserFeignService.insert(projectsUser);
            //修改项目人数
            Project project = projectFeignService.getById(projectId);
            project.setUserCount(project.getUserCount() + 1);
            projectFeignService.updete(project);
            //封装项目消息
            ProjectMessage projectMessage = new ProjectMessage();
            projectMessage.setProjectId(projectId);
            projectMessage.setTypeId(15);
            projectMessage.setTime(DateFromatUtil.getNowDate(new Date()));
            projectMessage.setAllFlag(1);
            //获取被邀请人信息
            MyUserDetails myUserDetailsByUserId = sysUserFeignService.getMyUserDetailsByUserId(notInProjectUserId);
            MyUserDetails inviteUser = sysUserFeignService.getMyUserDetailsByUserId(inProjectUserId);
            String msg = inviteUser.getUsername() + "成功邀请" + myUserDetailsByUserId.getUsername() + "加入团队";
            projectMessage.setMessage(msg);
            projectMessageFeignService.insert(projectMessage);
            //重新封装项目个人消息给邀请人
            projectMessage.setFromUserId(notInProjectUserId);
            projectMessage.setToUserId(inProjectUserId);
            projectMessage.setTypeId(9);
            projectMessage.setAllFlag(0);
            msg = myUserDetailsByUserId.getUsername() + "同意了你的邀请合作";
            projectMessage.setMessage(msg);
            projectMessageFeignService.insert(projectMessage);
            //处理关于这个项目邀请的消息和邀请
            List<ProjectUserCooperation> projectIdAndNotInProjectUserIdAndInvite = projectUserCooperationFeignService.getByProjectIdAndNotInProjectUserIdAndInviteAndFinish(projectId, notInProjectUserId, 1, 0);
            if (projectIdAndNotInProjectUserIdAndInvite != null) {
                Message message;
                MessageNeedToDoRelationship messageNeedToDoRelationship1;
                for (ProjectUserCooperation userCooperation : projectIdAndNotInProjectUserIdAndInvite) {
                    //标记项目对个人的所有邀请的消息已处理
                    messageNeedToDoRelationship1 = messageNeedToDoRelationshipFeignService.getByProjectsUserCooperationId(userCooperation.getId());
                    message = messageFeignService.getById(messageNeedToDoRelationship1.getMessageId());
                    message.setIsRead(0);
                    messageFeignService.update(message);
                    //标记邀请为完成
                    userCooperation.setFinishFlag(1);
                    projectUserCooperationFeignService.update(userCooperation);
                }
            }
            //处理项目的申请（待办）

            //设置跳转页面
            Map<String, Object> pathMap = new HashMap<>();
            pathMap.put("projectId", projectId);
            pathMap.put("userId", notInProjectUserId);
            String pathString = "/projects_view" + PathUtil.pathUtil(pathMap);
            return AJaxResponse.success(pathString, "处理完成");
        }
        return null;
    }

    @PutMapping("/doNotAgreeNeedToDo")
    @ResponseBody
    public AJaxResponse doNotAgreeNeedToDo(Integer messageId) {
        //通过messageId查找待办的事件
        MessageNeedToDoRelationship messageNeedToDoRelationship = messageNeedToDoRelationshipFeignService.getByMessageId(messageId);
        //如果是项目邀请
        if (messageNeedToDoRelationship.getProjectsUserCooperrationId() != 0) {
            ProjectUserCooperation userCooperation = projectUserCooperationFeignService.getById(messageNeedToDoRelationship.getProjectsUserCooperrationId());
            //标志邀请已完成
            userCooperation.setSuccessFlag(-1);
            //标志邀请已结束
            userCooperation.setFinishFlag(1);
            projectUserCooperationFeignService.update(userCooperation);
            //标志消息已处理
            Message message = messageFeignService.getById(messageNeedToDoRelationship.getMessageId());
            message.setIsRead(0);
            messageFeignService.update(message);
            //发送消息给邀请人，邀请失败
            //封装项目消息
            ProjectMessage projectsMessage = new ProjectMessage();
            projectsMessage.setProjectId(userCooperation.getProjectsId());
            projectsMessage.setTypeId(10);
            projectsMessage.setToUserId(userCooperation.getInProjectUserId());
            projectsMessage.setTime(DateFromatUtil.getNowDate(new Date()));
            //获取邀请人
            MyUserDetails inviteUser = sysUserFeignService.getSimpleMyUserDetailsByUserId(userCooperation.getNotInProjectUserId());
            String msg = inviteUser.getUsername() + "拒绝了你的邀请邀请";
            projectsMessage.setMessage(msg);
            projectMessageFeignService.insert(projectsMessage);
            return AJaxResponse.success("处理完成");
        }
        return null;
    }

    @GetMapping("/message_view")
    public String messages() {
        return "message";
    }

    @GetMapping("/message_person")
    @ResponseBody
    public List<Message> messagePerson(Integer userId, Integer offset, Integer pageSize) {
        return messageFeignService.getByUserIdAndOffsetAndPageSize(userId, 0, offset, pageSize);
    }

    @GetMapping("/messageCount")
    @ResponseBody
    public Integer messageCount(Integer userId) {
        return messageFeignService.getMessageCount(userId);
    }

    @GetMapping("/message_need_to_do")
    @ResponseBody
    public List<Message> message_need_to_do(Integer userId, Integer offset, Integer pageSize) {
        return messageFeignService.getByUserIdAndOffsetAndPageSize(userId, 1, offset, pageSize);
    }


}

