package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author changchen
 * @create 2020-03-21 10:50
 */
@Component
public class MyLB implements LoadBalancer {

    //原子引用
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //final修饰的方法不能被修改
    public final int getAndIncrement(){
        int current;
        int next;
        do {

            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("===next="+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> instances) {
        int index = getAndIncrement() % instances.size();
        return instances.get(index);
    }
}
