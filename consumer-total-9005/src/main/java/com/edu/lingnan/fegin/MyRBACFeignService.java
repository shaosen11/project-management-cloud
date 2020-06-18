package com.edu.lingnan.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:14:41
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface MyRBACFeignService {

    @GetMapping("/MyRBAC/findUrlsByEmail")
    List<String> findUrlsByEmail(@RequestParam("email") String email);

}