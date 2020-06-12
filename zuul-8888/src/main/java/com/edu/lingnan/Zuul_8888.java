package com.edu.lingnan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 9:13 2020/6/10
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Zuul_8888 {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_8888.class, args);
    }
}
