<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--内置对象--%>
<%
  pageContext.setAttribute("name1","qingjiang1");//保存的数据只在一个页面中有效
  request.setAttribute("name2","qingjiang2");//...只在一次请求中有效,请求转发会携带
  session.setAttribute("name3","qingjiang3");//...再一次会话中有效从打开浏览器,到关闭浏览器
  application.setAttribute("name4","qingjiang4");//...只在服务器中有效,从打开服务器到关闭服务器
%>

<%--通过pagecontext取出我们保存的值--%>
<%
//    也可以通过寻找的方式
    String name1 = pageContext.findAttribute("name1")+"";
    String name2 = pageContext.findAttribute("name2")+"";
    String name3 = pageContext.findAttribute("name3")+"";
    String name4 = pageContext.findAttribute("name4")+"";
    String name5 = pageContext.findAttribute("name5")+"";//不存在
    //pageContext.forward("pageDemo02.jsp");这样可以取到第二个
//    EL表达式输出最快,从底层到高层

%>
<h1>取出的值为</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
<h3><%=name5%></h3>
</body>
</html>
