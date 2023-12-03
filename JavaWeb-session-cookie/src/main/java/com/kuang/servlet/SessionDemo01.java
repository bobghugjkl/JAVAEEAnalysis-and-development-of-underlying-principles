package com.kuang.servlet;

import com.kuang.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //返回响应页面
        resp.setContentType("text/html;charset=utf-8");//将text转成html界面，然后设置格式为utf-8
        //得到session
        HttpSession session = req.getSession();
        //给session存东西
        session.setAttribute("name",new Person("秦江",1));
        //获取session的id
        String id = session.getId();
        //判断是否是新的Sessio
        if(session.isNew()){
            resp.getWriter().write("session创建成果,ID: "+id);
        }else{
            resp.getWriter().write("session已经存在");
        }
        //Session创建的时候做了什么事情,将它放到cookie里面,本质像cookie
//        Cookie cookie = new Cookie("JSESSIONID",id);
//        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
