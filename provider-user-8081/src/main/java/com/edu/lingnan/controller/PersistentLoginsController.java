package com.edu.lingnan.controller;

import com.edu.lingnan.feign.PersistentLoginsFeignService;
import com.edu.lingnan.service.PersistentLoginsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PersistentLogins)表控制层
 *
 * @author makejava
 * @since 2020-06-12 14:59:21
 */
@RestController
@RequestMapping("persistentLogins")
public class PersistentLoginsController {
    /**
     * 服务对象
     */
    @Resource
    private PersistentLoginsService persistentLoginsService;



}