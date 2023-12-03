package com.kuang.filter;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class LoginAccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //用户未登录时拦截
        //先基于Http请求
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取请求路径
        String uri = request.getRequestURI();
        //看是不是指定页面
        if(uri.contains("/login.jsp")){
            //放行
            filterChain.doFilter(request,response);
            return;
        }
        //放行静态资源
        if(uri.contains("/js")||uri.contains("/image")||uri.contains("/css"))
        {
            filterChain.doFilter(request,response);
            return;
        }
        //放行请求操作
        if(uri.contains("/login"))
        {
            filterChain.doFilter(request,response);
            return;
        }
        //放行登录状态，判断session
        String uname = request.getSession().getAttribute("user")+"";
        if(uname!=null){
            filterChain.doFilter(request,response);
            return;
        }
        //未登录的时候拦截请求跳转到登录页面
        response.sendRedirect("login.jsp");
    }

    @Override
    public void destroy() {

    }
}
