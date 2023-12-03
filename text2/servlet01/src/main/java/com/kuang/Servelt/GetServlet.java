package com.kuang.Servelt;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进入了getc");
        ServletContext context = this.getServletContext();//数据在上面
        String username = (String) context.getAttribute("username");
        resp.setContentType("text/html");//响应识别回来
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("name:"+username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
