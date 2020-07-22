package com.cky.microService.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cky.microService.myHandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimit2Controller {

    @GetMapping(value = "/testA")
    @SentinelResource(value = "testA",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public String testA() {
        return "------testA";
    }

    @GetMapping(value = "/testB")
    @SentinelResource(value = "testB",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public String testB() {
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

    @GetMapping(value = "/testD")
    @SentinelResource(value = "testD",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
//        int age = 10/0;
        return "------testD";
    }

    @GetMapping(value = "/testE")
    @SentinelResource(value = "testE",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    /**
     * 热点key测试
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        //int age = 10/0;
        return "------testHotKey";
    }
    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";  //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }

}

