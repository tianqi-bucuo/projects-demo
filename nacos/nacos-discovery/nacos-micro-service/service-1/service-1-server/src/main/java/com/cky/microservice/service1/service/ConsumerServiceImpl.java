package com.cky.microservice.service1.service;

import com.cky.microservice.service1.api.ConsumerService;
import com.cky.microservice.service2.api.ProviderService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

@Service //Dubbo注解,标记此类的方法暴露为dubbo接口
public class ConsumerServiceImpl implements ConsumerService {

    //注入service
    @Reference
    ProviderService providerService;

    // dubbo接口实现内容
    public String service() {
        //远程调用
        String service = providerService.service();
        return "Consumer invoke |" + service;
    }
}
