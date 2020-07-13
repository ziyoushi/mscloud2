package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author changchen
 * @create 2020-03-22 16:57
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackServiceImpl.class)
public interface PaymentHystrixService {

    @GetMapping("/hystrix/payment/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/payment/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
