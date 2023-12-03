package com.xxxx.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.xxxx.api.service.UserServiceI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
public class UserInit implements CommandLineRunner {
    @Reference(interfaceClass = UserServiceI.class)
    private UserServiceI userServiceI;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(userServiceI.selectUserById(2));
    }
}
