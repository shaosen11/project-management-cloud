package com.edu.lingnan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.stereotype.Controller;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 9:40 2020/6/1
 */
@SpringBootApplication
@Controller
@EnableEurekaServer //eureka启动类，可以接受被人注册进来
public class EurekaServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7001.class, args);
    }
}
