package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author changchen
 * @create 2020-04-04 19:19
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){

        return restTemplate.getForObject(serverURL+"/nacos/getPayment/"+id,String.class);
    }

}
