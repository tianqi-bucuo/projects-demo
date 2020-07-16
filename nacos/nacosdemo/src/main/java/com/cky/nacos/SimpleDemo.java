package com.cky.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import java.util.Properties;

public class SimpleDemo {
    public static void main(String[] args) throws NacosException {
        String serverAddr = "127.0.0.1:8848";
        String dataId = "nacosSimpleDemo";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);



//    Properties properties = new Properties();
//    properties.put("serverAddr",serverAddr);
//    ConfigService configService = NacosFactory.createConfigService(properties);
//    //获取配置,String dataId, String group, long timeoutMs
//    String content = configService.getConfig(dataId, group, 5000);
//    System.out.println(content);
    }
}
