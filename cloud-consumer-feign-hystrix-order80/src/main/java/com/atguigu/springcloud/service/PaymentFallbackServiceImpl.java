package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author changchen
 * @create 2020-03-22 22:25
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService{

    @Override
    public String paymentInfoOk(Integer id) {
        return "PaymentFallbackServiceImpl fall back ok";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "PaymentFallbackServiceImpl fall back timeout";
    }
}
