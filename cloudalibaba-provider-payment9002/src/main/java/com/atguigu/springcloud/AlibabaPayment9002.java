package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author changchen
 * @create 2020-04-04 19:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPayment9002.class,args);
    }
}
