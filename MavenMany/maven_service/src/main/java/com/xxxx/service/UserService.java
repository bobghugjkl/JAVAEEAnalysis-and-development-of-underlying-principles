package com.xxxx.service;

import com.xxxx.dao.UserDao;

public class UserService {
    public static void textService(){
        System.out.println("service ok");
        //调用maven_dao方法
        UserDao.textDao();
    }
}
