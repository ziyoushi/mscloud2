package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author changchen
 * @create 2020-03-08 17:41
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/save")
    public CommonResult<Payment> save(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/save",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null && instances.size() <= 0){
            return  null;
        }
        ServiceInstance instance = loadBalancer.instances(instances);
        URI uri = instance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping("/payment/zipkin")
    public String getPaymentZipkin(){

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null && instances.size() <= 0){
            return  null;
        }
        ServiceInstance instance = loadBalancer.instances(instances);
        URI uri = instance.getUri();

        return restTemplate.getForObject(uri+"/payment/zipkin",String.class);
    }

}
