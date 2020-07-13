package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author changchen
 * @create 2020-04-04 14:24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPayment9001 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPayment9001.class,args);
    }
}
