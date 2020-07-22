package com.cky.microService.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cky.microService.entity.CommonResult;

public class CustomerBlockHandler {

    public static String handlerException(BlockException exception) {
        return "自定义handler";
    }

    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444,"自定义byResource限流");
    }

}
