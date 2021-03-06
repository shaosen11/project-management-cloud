package com.edu.lingnan.controller;

import com.edu.lingnan.entity.UserRecord;
import com.edu.lingnan.feign.UserRecordFeignService;
import com.edu.lingnan.service.UserRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserRecord)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:19:02
 */
@RestController
@RequestMapping("userRecord")
public class UserRecordController {
    /**
     * 服务对象
     */
    @Resource
    private UserRecordService userRecordService;



}