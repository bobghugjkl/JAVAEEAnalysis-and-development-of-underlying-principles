package com.kuang.Servelt;

import javax.servlet.http.HttpServlet;
import java.util.Properties;

public class PropertiesServlet extends HttpServlet {
    public void text(){
        Properties properties = new Properties();
        //properties.load("");load一些流什么的，一般用读取文件绝对地址，但是现在是web没有什么绝对地址
    }
}
