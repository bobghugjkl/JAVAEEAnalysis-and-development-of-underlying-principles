package com.kuang.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//在线人数监听
public class OnlineCountListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();//获取session并获取上下文,可以让他全局改
        System.out.println(httpSessionEvent.getSession().getId());
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");

        if(onlineCount == null){
            onlineCount = new Integer(1);
        }else{
            int count = onlineCount.intValue();//装箱拆箱，类型转换
            onlineCount = new Integer(count + 1);
        }
        servletContext.setAttribute("OnlineCount",onlineCount);//更新
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();//获取session并获取上下文
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");//存数据，在外面可以取

        if(onlineCount == null){
            onlineCount = new Integer(0);
        }else{
            int count = onlineCount.intValue();//装箱拆箱，类型转换
            onlineCount = new Integer(count - 1);
        }
        servletContext.setAttribute("OnlineCount",onlineCount);//更新
    }
}
