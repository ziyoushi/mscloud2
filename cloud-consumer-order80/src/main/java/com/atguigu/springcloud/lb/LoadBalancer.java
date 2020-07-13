package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author changchen
 * @create 2020-03-21 10:47
 */
public interface LoadBalancer {
    ServiceInstance instances (List<ServiceInstance> instances);
}
