package com.cky.microService.controller;


import com.cky.microService.entity.CommonResult;
import com.cky.microService.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    // 模拟数据库
    public static HashMap<Long,Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L,new Payment(1L,"11111111111111111111111111111111"));
        hashMap.put(2L,new Payment(2L,"22222222222222222222222222222222"));
        hashMap.put(3L,new Payment(3L,"33333333333333333333333333333333"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        //模拟数据库查询
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200,"Success", payment);
        return result;
    }

    @GetMapping("/consumer/fallback/{id}")
    public CommonResult<Payment> fallback(@PathVariable Long id) {

        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "Success", payment);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }
}