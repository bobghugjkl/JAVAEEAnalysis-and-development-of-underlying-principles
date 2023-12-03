package com.kuang.servlet;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

//中文数据传递
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-16");
        resp.setCharacterEncoding("utf-16");

        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            out.write("上一次访问:");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if(cookie.getName().equals("name")){
                    System.out.println(cookie.getValue());
                    //URLDecoder.decode(cookie.getValue(),"utf-8");//解码
                    out.write(URLDecoder.decode(cookie.getValue(),"utf-8"));
                }
            }



        }else{
            out.write("第一次访问:");
        }
        Cookie cookie = new Cookie("name", "秦江");//转码

        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
