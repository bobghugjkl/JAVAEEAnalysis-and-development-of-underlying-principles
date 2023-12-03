package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上一次访问的时间
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器告诉你你来的时间，将这个时间封装成信件，下次带来
        //先解决乱码
        req.setCharacterEncoding("utf-16");//utf-16可以看到中文
        resp.setCharacterEncoding("utf-16");
        //想要响应式输出,响应就是resp
        PrintWriter out = resp.getWriter();
        //Cookie服务器从客户端获取
        Cookie[] cookies = req.getCookies();//cookie可能存在多个

        //判断cookie是否存在
        if(cookies!=null){
            //如果存在怎么办
            out.write("你上一次访问的时间是:");
//            for (Cookie cookie : cookies) {
//
//            }
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];//取
                //获得cookie的名字
                if(cookie.getName().equals("LastLoginTime")){
                    //获取cookie中的值
                    //cookie.getValue();
                    long lastLoginTime = Long.parseLong(cookie.getValue());//将它变成一个Date,时间戳
                    Date date = new Date(lastLoginTime);//date对象
                    out.write(date.toLocaleString());//这里toString()不对,会检测到null，导致空指针异常，报500
                }

            }
        }else{
            out.write("这是第一次访问");
        }
        //服务器发cookie
        Cookie cookie = new Cookie("LastLoginTime", System.currentTimeMillis()+"");
        //此时这样的话如果关掉对话（浏览器），cookie将消失
        //不让它消失，设置一个有效期
        cookie.setMaxAge(24*60*60);//有效期为一天,浏览器消失了cookie还存在，不安全
        resp.addCookie(cookie);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
