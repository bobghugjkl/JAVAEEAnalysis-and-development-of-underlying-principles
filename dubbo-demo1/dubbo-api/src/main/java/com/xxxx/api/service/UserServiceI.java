package com.xxxx.api.service;

import com.xxxx.api.pojo.User;

/**
 * 服务接口
 */
public interface UserServiceI {
    User selectUserById(Integer userId);
}