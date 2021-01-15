package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.logging.Logger;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id")Integer id) {
        String result = paymentService.paymentInfo_Ok(id);
        System.out.println("result"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        System.out.println("result"+result);
        return result;
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        return result;
    }


    public static void main(String[] args) {
//        Jedis jedis = new Jedis("127.0.0.1",6379);
//        jedis.set("money","100");
//        jedis.set("out","0");
//        jedis.watch("money");
//        Transaction transaction = jedis.multi();
//        try {
//            transaction.decrBy("money", 10l);
//            transaction.incrBy("out", 10l);
//            transaction.exec();
//        } catch (Exception e) {
//            e.printStackTrace();
//            jedis.unwatch();
//        } finally {
//            System.out.println(jedis.get("money"));
//            System.out.println(jedis.get("out"));
//            jedis.close();

//        }

    }
}
