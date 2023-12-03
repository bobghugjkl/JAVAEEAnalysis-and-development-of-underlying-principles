package org.example.text;

import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class start01 {
    public static void main(String[] args) {
        //获取spring上下文环境
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        //id属性值得到bean对象,将new的过程交给IOC去做了
        UserService userService = (UserService) ac.getBean("userService");
        //测试实例化好的Javabean中的方法
        userService.text();
    }
}
