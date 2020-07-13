package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changchen
 * @create 2020-04-04 20:19
 */
@RestController
@Slf4j
@RefreshScope //开启自动刷新配置
public class ConfigController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "Server Port:"+serverPort +"\t\n\n configInfo: " + configInfo;
    }


}
