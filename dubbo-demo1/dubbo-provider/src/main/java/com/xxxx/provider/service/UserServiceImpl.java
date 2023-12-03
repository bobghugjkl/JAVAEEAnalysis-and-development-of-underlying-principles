package com.xxxx.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xxxx.api.pojo.User;
import com.xxxx.api.service.UserServiceI;
import org.springframework.stereotype.Component;

/**
 * 服务实现
 */
@Service(interfaceClass = UserServiceI.class)//暴露服务
@Component
public class UserServiceImpl implements UserServiceI {
    @Override
    public User selectUserById(Integer userId) {
        User user = new User();
        user.setId(userId);
        user.setName("admin");
        user.setPwd("123456");
        System.out.println("userId:" + userId);
        return user;
    }
}