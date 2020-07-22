package com.cky.sentinelCluster.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client2Controller {

    @Value("${server.port}")
    private String Port;

    @GetMapping("server")
    @SentinelResource(value = "server")
    public String service(){
        return "client2";
    }
}
