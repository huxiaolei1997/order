package com.imooc.order.controller;

import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ClientController {
    //@Autowired
    //private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // 如果一开始配置了 hosts 文件，那么这里的product 也需要在 hosts 里面配置映射
        // 1. 第一种方式
//        RestTemplate restTemplate = new RestTemplate(); // 直接使用 RestTemplate， url写死
//        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);

        // 2. 第二种方式（利用 loadBalancerClient 通过应用名获取 url, 然后再使用）
        //ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        //String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
        //RestTemplate restTemplate = new RestTemplate();
        //String response = restTemplate.getForObject(url, String.class);

        // 3. 第三种方式（利用@LoadBalanced, 可在 restTemplate 里使用应用名字）
        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        log.info("response={}", response);
        return response;
    }
}
