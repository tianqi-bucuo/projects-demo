package com.cky.microService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    private static final Logger LOG = LoggerFactory.getLogger(ProviderController.class);

    @Value("${server.port}")
    private String Port;

    @GetMapping
    public String service(){
        LOG.info("provider invoke");
        return "provider invoke";
    }
}
