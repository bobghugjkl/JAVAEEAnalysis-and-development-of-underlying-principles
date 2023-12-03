package com.xxxx.servlet;

import com.xxxx.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/f02")
public class FreeMaker02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //添加数据
        request.setAttribute("msg", "Hello FreeMarker!");

        //boolean（布尔）类型
        request.setAttribute("flag", true);

        // 日期类型  new Data()表示获取现在电脑的时间
        request.setAttribute("createDate", new Date());

        // 数值类型
        request.setAttribute("age", 18); // 数值型
        request.setAttribute("salary", 10000); // 数值型
        request.setAttribute("avg", 0.545); // 浮点型

        // 字符串类型
        request.setAttribute("msg1", "Hello ");
        request.setAttribute("msg2", "freemarker");

        // 序列类型 （数组、List、Set）
// 数组操作
        String[] stars = new String[]{"周杰伦","林俊杰","陈奕迅","五月天"};
        request.setAttribute("stars",stars);

// List操作
        List<String> citys = Arrays.asList("上海","北京","杭州","深圳");
        request.setAttribute("cityList",citys);

// JavaBean集合
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"zhangsan",22));
        userList.add(new User(2,"lisi",18));
        userList.add(new User(3,"wangwu",20));
        request.setAttribute("userList",userList);
        // Map操作
        Map<String,String> cityMap = new HashMap<>();
        cityMap.put("sh","上海");
        cityMap.put("bj","北京");
        cityMap.put("sz","深圳");
        request.setAttribute("cityMap",cityMap);


        //请求跳转到ft1文件中
        request.getRequestDispatcher("template/f02.ftl").forward(request, response);
    }
}
