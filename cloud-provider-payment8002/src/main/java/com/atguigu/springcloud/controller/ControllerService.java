package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ControllerService {

    @Value("${server.port}")
    private String Serverport;

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return Serverport;
    }
}
