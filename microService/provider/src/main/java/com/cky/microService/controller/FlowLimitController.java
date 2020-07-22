package com.cky.microService.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cky.microService.entity.CommonResult;
import com.cky.microService.myHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",     // value是资源名
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException1")
    public CommonResult byResource() {
        return new CommonResult(200,"按资源名称限流测试接口");
    }

}