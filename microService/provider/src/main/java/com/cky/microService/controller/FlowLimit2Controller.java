package com.cky.microService.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimit2Controller {

    @GetMapping(value = "/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        return "------testB";
    }

    @GetMapping(value = "/testD")
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
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        //int age = 10/0;
        return "------testHotKey";
    }

}

