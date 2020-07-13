package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author changchen
 * @create 2020-04-04 19:17
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosOrderMain83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain83.class,args);
    }
}
