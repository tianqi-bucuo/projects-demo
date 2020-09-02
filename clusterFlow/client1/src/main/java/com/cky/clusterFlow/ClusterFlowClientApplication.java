package com.cky.clusterFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cky.clusterFlow"})
public class ClusterFlowClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClusterFlowClientApplication.class, args);
    }
}
