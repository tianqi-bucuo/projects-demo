package com.cky.microService.service;

import com.cky.microService.entity.CommonResult;
import com.cky.microService.entity.Info;
import org.springframework.stereotype.Component;

@Component
public class InfoFallbackService implements InfoService {

    @Override
    public CommonResult<Info> query(Long id) {
        return new CommonResult<>(444,"--服务降级返回--", new Info(id,"errorSerial"));
    }

}
