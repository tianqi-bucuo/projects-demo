package com.cky.microService.service;

import com.cky.microService.entity.CommonResult;
import com.cky.microService.entity.Info;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider2", fallback = InfoFallbackService.class)
public interface InfoService {

    @GetMapping("/query/{id}")
    public CommonResult<Info> query(@PathVariable("id") Long id);

}
