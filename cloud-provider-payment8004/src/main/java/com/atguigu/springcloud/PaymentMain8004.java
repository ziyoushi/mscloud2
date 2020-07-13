package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author changchen
 * @create 2020-03-15 21:22
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解 用于向consul和zookeeper作为注册中心时 注册服务
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
