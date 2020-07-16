package com.cky.microservice.application1.controller;

import com.cky.microservice.service1.api.ConsumerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Application1Controller {

    //注入service（基于dubbo协议）
    @Reference  //生成接口代理对象，通过代理对象进行远程调用
    ConsumerService consumerService;

    @GetMapping("/service")
    public String service(){
        //远程调用
        String service = consumerService.service();
        return "test |" + service;
    }
}
