package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PayementFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "PayementFallbackService  paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PayementFallbackService paymentInfo_TimeOut";
    }
}
