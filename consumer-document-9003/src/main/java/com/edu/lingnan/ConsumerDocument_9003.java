package com.edu.lingnan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 23:20 2020/6/11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerDocument_9003 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerDocument_9003.class, args);
    }
}
