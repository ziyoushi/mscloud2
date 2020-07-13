package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author changchen
 * @create 2020-03-08 10:04
 */
@Mapper
public interface PaymentDao {

    public int save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
