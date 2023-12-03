package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/f01")
public class FreeMaker01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //给模板设置数据
        req.setAttribute("msg","Hello FreeMaker!");
        //请求转发
        req.getRequestDispatcher("template/f01.ftl").forward(req,resp);
    }
}
