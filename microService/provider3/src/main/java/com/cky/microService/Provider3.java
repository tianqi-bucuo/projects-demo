package com.cky.microService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Provider3
{
    public static void main(String[] args) {
        SpringApplication.run(Provider3.class, args);
    }
}
