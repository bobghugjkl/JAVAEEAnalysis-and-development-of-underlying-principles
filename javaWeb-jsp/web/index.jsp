<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/11/26
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  这是注释--%>
<%--  JSP表达式--%>
<%--将程序的输出输出到客户端
<%=变量或者表达式%>
--%>
  <%=new java.util.Date()%>
<%--  脚本片段--%>
  <%
    int sum = 0;
    for (int i = 0; i < 100; i++) {
      sum += i;
    }
    out.println("<h1>Sum="+sum+"</h1>");
  %>
<%--  脚本片段的再实现--%>
  <%
    int x = 10;
    out.println(x);
  %>
  <p>这是一个jsp文档</p>
<%
  int y = 10;
  out.println(y);
  out.println(x);
%>
  <hr>
<%--  在代码中嵌入html元素--%>
  <%
    for (int i = 0; i < 5; i++) {


  %>
  <h1>HelloWorld</h1>
  <%
    }
  %>
  </body
  <hr>
<%!
  //JSP声明，会被编译到JSP生成java的类中，其他的会生成到_jspService方法！定义方法和全局变量
  static {
    System.out.println("Loading");
  }
  private int globalVar = 0;
  public void kuang(){
    System.out.println("进入kuang");
  }
%>
<%--EL表达式--%>
<% for (int i = 0; i < 5; i++) { %>
  <h1>Hello,World ${i}</h1>
<%} %>
<%--定制错误页面
--%>
<%@ page errorPage="index.jsp" %>
<%--导包--%>
<%@page import="java.util.*" %>
<%= new Date()%>

</html>
