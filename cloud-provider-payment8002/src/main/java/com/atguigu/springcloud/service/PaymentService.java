package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author changchen
 * @create 2020-03-08 10:22
 */
public interface PaymentService {
    public int save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
