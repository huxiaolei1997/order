package com.imooc.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2019年07月14日 11:10 胡晓磊 Exp $
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    // 超时配置
//    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 设置熔断
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 时间窗口中最小请求数 10
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 断路器时间窗口
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 时间窗口中调用失败的百分比
//    })
    @GetMapping("getProductInfoList")
    @HystrixCommand
    public String getProductInfoList(@RequestParam("number") Integer number) {
        if (number % 2 == 0) {
           return "success";
        }

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8080/product/listForOrder"
                , Arrays.asList("157875196366160022")
                , String.class);
        // 抛一个异常也会出现降级

    }

    private String fallback() {
        return "太拥挤了，请稍后再试~";
    }

    private String defaultFallback() {
        return "默认提示，太拥挤了，请稍后再试~";
    }
}
