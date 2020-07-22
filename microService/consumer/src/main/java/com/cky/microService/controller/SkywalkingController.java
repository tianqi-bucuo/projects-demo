package com.cky.microService.controller;

import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkywalkingController {

    //获取trace id，可以在RocketBot追踪中进行查询
    @GetMapping("/consumer/getTraceId")
    public String getTraceId(){
        //使当前链路报错，并且提示报错信息
        ActiveSpan.error(new RuntimeException("Test-Error-Throwable"));
        //打印info信息
        ActiveSpan.info("Test-Info-Msg");
        //打印debug信息
        ActiveSpan.debug("Test-debug-Msg");
        return TraceContext.traceId();
    }
}
