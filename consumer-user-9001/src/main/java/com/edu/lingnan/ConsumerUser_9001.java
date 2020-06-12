package com.edu.lingnan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 17:18 2020/6/7
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerUser_9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerUser_9001.class, args);
    }
}
