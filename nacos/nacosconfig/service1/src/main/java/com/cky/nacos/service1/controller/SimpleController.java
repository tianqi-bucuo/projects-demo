package com.cky.nacos.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String simple(){
        return "login";
    }

//    @Value("${server111.port111}")
//    private String config1;

    // 配置上下文
    @Autowired
    ConfigurableApplicationContext applicationContext;

    @GetMapping("/configs")
    public String getConfigs(){
        String name = applicationContext.getEnvironment().getProperty("student.name");
        String age = applicationContext.getEnvironment().getProperty("student.age");
        //读取实时配置信息
        return applicationContext.getEnvironment().getProperty("server111.port111") + "姓名：" + name + "年龄" + age;
    }
}
