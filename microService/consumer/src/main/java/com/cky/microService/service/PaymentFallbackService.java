package com.cky.microService.service;

import com.cky.microService.entity.CommonResult;
import com.cky.microService.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,---PaymentFallbackService", new Payment(id,"errorSerial"));
    }

    @Override
    public CommonResult<Payment> fallback(Long id) {
        return new CommonResult<>(444,"服务降级返回,---PaymentFallbackService", new Payment(id,"errorSerial"));
    }

}
