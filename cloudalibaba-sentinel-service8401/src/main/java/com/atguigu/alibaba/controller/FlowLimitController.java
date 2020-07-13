package com.atguigu.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changchen
 * @create 2020-04-07 20:34
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "----testB";
    }

}
