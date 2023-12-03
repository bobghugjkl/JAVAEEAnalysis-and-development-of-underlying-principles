package com.kuang.Servelt;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了Doget方法");
        PrintWriter writer = resp.getWriter();//相应流
        ServletInputStream inputStream = req.getInputStream();//找到输入
        writer.print("hello");
        //this.getInitParameter()初始化参数
        //this.getServletConfig()Servelt配置
        //this.getServletContext()Servlet上下文
        ServletContext context = this.getServletContext();
        String username = "秦江";//数据
        context.setAttribute("username",username);//讲一个数据保存在了ServletContext中，名字username，值username
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
