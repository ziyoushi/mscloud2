package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changchen
 * @create 2020-04-04 19:01
 */
@RestController
@RequestMapping("/nacos")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPayment/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "nacos register,server port :" +serverPort +"\t id:"+id;
    }

}
