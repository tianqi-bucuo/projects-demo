package com.cky.nacos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "provider") // value是服务名
public interface ProviderClient {

    @GetMapping("/service")
    public String service();

}
