package com.cky.microService.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 自定义过滤器
 */
@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter, Ordered {

    /**
     * 实现请求时要传入username这个参数
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){

        log.info("***********come in MyGateWayFilter:  "+new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");

        if(username == null){
            log.info("*******用户名为null，非法用户，o(╥﹏╥)o");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder(){
        return 0;
    }
}
