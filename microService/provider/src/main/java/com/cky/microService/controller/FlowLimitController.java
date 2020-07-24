package com.cky.microService.controller;

import com.cky.microService.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/byResource")
    public CommonResult byResource() {
        return new CommonResult(200,"按资源名称限流测试接口");
    }

}