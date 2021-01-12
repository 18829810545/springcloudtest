package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageprovider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageCotroller {
    @Autowired
    private IMessageprovider iMessageprovider;

    @GetMapping("/sendMessage")
    public String send(){
        return iMessageprovider.send();
    }
}
