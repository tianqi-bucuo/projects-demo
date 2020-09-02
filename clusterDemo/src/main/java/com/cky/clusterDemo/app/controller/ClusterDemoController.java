package com.cky.clusterDemo.app.controller;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.cky.clusterDemo.app.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClusterDemoController {

    @Autowired
    private DemoService service;

    @Autowired
    private SentinelResourceAspect sentinelResourceAspect;

    @GetMapping("/hello/{name}")
    public String apiHello(@PathVariable String name) throws Exception {
        return service.sayHello(name);
    }

}
