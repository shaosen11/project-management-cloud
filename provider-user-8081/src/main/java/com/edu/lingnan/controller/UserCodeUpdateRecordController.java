package com.edu.lingnan.controller;

import com.edu.lingnan.entity.UserCodeUpdateRecord;
import com.edu.lingnan.feign.UserCodeUpdateRecordFeignService;
import com.edu.lingnan.service.UserCodeUpdateRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserCodeUpdateRecord)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:18:43
 */
@RestController
@RequestMapping("userCodeUpdateRecord")
public class UserCodeUpdateRecordController {
    /**
     * 服务对象
     */
    @Resource
    private UserCodeUpdateRecordService userCodeUpdateRecordService;
}