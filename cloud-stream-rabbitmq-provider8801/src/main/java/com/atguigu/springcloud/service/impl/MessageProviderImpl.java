package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author changchen
 * @create 2020-04-03 20:14
 */
@EnableBinding({Source.class})
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {

        String serialNo = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serialNo).build());
        log.info("流水号：{}",serialNo);
        return serialNo;
    }
}
