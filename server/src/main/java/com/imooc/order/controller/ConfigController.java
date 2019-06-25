package com.imooc.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaolei hu
 * @date 2018/10/7 16:28
 **/
@RestController
@RequestMapping("/config")
@RefreshScope // 如果没有配置webhooks（在git服务端配置，这个可以找到的） ,那么每次更新配置前必须 post 请求 config 服务的 actuator/refresh，这样新的配置才会生效
public class ConfigController {
    @Value("${env}")
    private String env;

    @GetMapping("/print")
    public String getEnv(){
        return env;
    }
}
