package com.cky.microService.service;

import com.cky.microService.entity.CommonResult;
import com.cky.microService.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider2", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

    @GetMapping("/consumer/fallback/{id}")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id);

}
