package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author changchen
 * @create 2020-03-08 10:26
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment){
        int result = paymentService.save(payment);
        log.info("插入结果="+result+"哈啊哈");
        if (result >0){
            return new CommonResult(200,"插入数据库成功,端口号：" + serverPort,result);
        }else {
            return new CommonResult(500,"插入数据库失败",null);
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("插入结果="+payment);
        if (null != payment){
            return new CommonResult(200,"查询成功,端口号："+serverPort,payment);
        }else {
            return new CommonResult(500,"查询失败",null);
        }
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String getPaymentZipKin(){
        return "hello,welcome to zipkin!";
    }


}
