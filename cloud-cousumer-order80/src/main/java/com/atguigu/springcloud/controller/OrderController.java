package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;


@RestController
@Slf4j
public class OrderController {
   public static final String payment_url = "http://CLOUD-PAYMENT-SERVICE";

   @Autowired
   private RestTemplate restTemplate;

   @Autowired
   private LoadBalancer loadBalancer;

   @Autowired
   private DiscoveryClient discoveryClient;

   @GetMapping(value = "/consumer/payment/lb")
   public String getPaymentLb() {
       List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
       System.out.println(instances.get(0).getPort()+"/t"+instances.get(0).getUri());
       if (instances == null || instances.size() <= 0) {
           return null;
       }
       ServiceInstance serviceInstance= loadBalancer.instance(instances);
       URI uri = serviceInstance.getUri();
       return restTemplate.getForObject(uri+"/payment/lb",String.class);
   }

}
