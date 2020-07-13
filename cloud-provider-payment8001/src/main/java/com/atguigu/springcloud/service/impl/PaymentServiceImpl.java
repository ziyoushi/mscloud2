package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author changchen
 * @create 2020-03-08 10:22
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    //@Resource 也可以使用Java自带的依赖注入
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
