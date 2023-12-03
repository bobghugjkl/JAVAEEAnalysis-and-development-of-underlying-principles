package com.xxxx.servlet;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        实例化一个模板对象
        Configuration configuration = new Configuration();
//        模板路径,设置加载模板的上下文
        configuration.setServletContextForTemplateLoading(getServletContext(),"/template");
//        设置编码格式
        configuration.setDefaultEncoding("UTF-8");
//        加载模板文件
        Template template = configuration.getTemplate("news.ftl");
//        设施数据模型,process()需要
        Map<String, Object> map = new HashMap<>();
        map.put("title","This is title");
        map.put("source","This is source");
        map.put("pubTime","2023.11.29");
        map.put("content","This is content");
//        获取根目录(获取文件存放路径)
        String basePath = req.getServletContext().getRealPath("/");
//        设置HTML的存放路径
        File htmlFile = new File(basePath + "/html");
//        判断文件目录是否存在
        if(!htmlFile.exists()){
//            如果不存在，则新建文件目录
            htmlFile.mkdir();
        }
//        得到生成文件名，用时间戳最方便
        String filename = System.currentTimeMillis()+".html";
//        得到文件对象，创建文件
        File file = new File(htmlFile,filename);
//        获取文件输出流
        FileWriter writer = new FileWriter(file);
//        生成
        try {
            template.process(map,writer);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }finally {
            writer.flush();
            writer.close();
        }
    }
}
