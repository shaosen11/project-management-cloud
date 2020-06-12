package com.edu.lingnan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 20:56 2020/6/11
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderProjectApplication_8082 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderProjectApplication_8082.class, args);
    }
}
