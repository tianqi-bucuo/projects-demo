package com.cky.microService.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cky.microService.entity.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444,"自定义global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444,"自定义global handlerException----2");
    }
}
