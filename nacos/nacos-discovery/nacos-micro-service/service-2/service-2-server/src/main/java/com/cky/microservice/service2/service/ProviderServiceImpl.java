package com.cky.microservice.service2.service;

import com.cky.microservice.service2.api.ProviderService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String service() {
        return "Provider invoke";
    }
}
