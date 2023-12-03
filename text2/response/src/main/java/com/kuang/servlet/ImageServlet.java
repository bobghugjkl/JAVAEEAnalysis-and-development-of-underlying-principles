package com.kuang.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器5秒刷新一次,都是通过setheader键值对
        resp.setHeader("refresh","3");

        //内存中生成图片,需要宽高,颜色
        BufferedImage bufferedImage = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();//画笔,2D什么的都有
        //设置背景
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,80,20);
        //写数据
        graphics.setColor(Color.blue);
        graphics.setFont(new Font(null,Font.LAYOUT_NO_LIMIT_CONTEXT,20));//字体
        graphics.drawString(makenumber(),0,20);

        //告诉浏览器这个请求用图片的方式展开
        resp.setContentType("image/jpeg");//设置他的类型
        //网站存在缓存，不让他缓存
        resp.setDateHeader("expires",-1);//让他不去缓存
        resp.setHeader("Cache-Control","no-cache");//缓存控制
        resp.setHeader("Pragma","no-cache");
        //把图片写给浏览器
        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());

    }
    //生成随机数
    private String makenumber(){
        Random random = new Random();
        String s = random.nextInt(9999999) + "";
        //随机数往外面写
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 7-s.length(); i++) {
            stringBuffer.append("0");//哪怕随机生成了一个三位数也没事，会补零

        }
        s = stringBuffer.toString() + s;
        return s;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
