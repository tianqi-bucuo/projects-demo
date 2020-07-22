package com.cky.microService.controller;

import com.cky.microService.entity.CommonResult;
import com.cky.microService.entity.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class InfoController {

    @Value("${server.port}")
    private String serverPort;

    // 模拟数据库
    public static HashMap<Long,Info> hashMap = new HashMap<>();

    static {
        hashMap.put(1L,new Info(1L,"11111111111111111111111111111111"));
        hashMap.put(2L,new Info(2L,"22222222222222222222222222222222"));
        hashMap.put(3L,new Info(3L,"33333333333333333333333333333333"));
    }

    @GetMapping("/query/{id}")
    public CommonResult<Info> query(@PathVariable Long id) {

        if (id < 1){
            throw new IllegalArgumentException ("非法参数异常");
        }

        Info info = hashMap.get(id);
        CommonResult<Info> result = new CommonResult<>(200, "Success", info);

        if (result.getData() == null) {
            throw new NullPointerException ("该ID无对应记录");
        }
        return result;
    }
}
