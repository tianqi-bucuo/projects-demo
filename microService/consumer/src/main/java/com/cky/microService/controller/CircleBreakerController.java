package com.cky.microService.controller;

import com.cky.microService.entity.CommonResult;
import com.cky.microService.entity.Info;
import com.cky.microService.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController{

    @Resource
    private InfoService infoService;

    @GetMapping("/query/{id}")
    //@SentinelResource(value = "fallback") //没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    public CommonResult<Info> fallback(@PathVariable("id") Long id) {
        return infoService.query(id);
    }

    //fallback指定的方法
    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Info info = new Info(id,"null");
        return new CommonResult<>(444,"handlerFallback异常处理, exception内容  "+e.getMessage(), info);
    }
    //blockHandler指定的方法
//    public CommonResult blockHandler(@PathVariable  Long id,BlockException blockException) {
//        Info info = new Info(id,"null");
//        return new CommonResult<>(445,"blockHandler-sentinel限流 " + blockException.getMessage(), info);
//    }

}
