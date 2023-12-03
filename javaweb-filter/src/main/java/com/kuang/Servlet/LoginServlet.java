package com.kuang.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("用户请求");
        System.out.println(req.getParameter("uname"));
        //如果是admin表示成功
        String uname = req.getParameter("uname");
        if("admin".equals(uname)){
            resp.sendRedirect("index.jsp");
            //存一下session
            req.getSession().setAttribute("user",uname);
        }else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
