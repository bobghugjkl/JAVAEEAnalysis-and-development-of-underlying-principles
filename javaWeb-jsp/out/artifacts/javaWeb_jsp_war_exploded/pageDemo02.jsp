<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  //    也可以通过寻找的方式
  String name1 = pageContext.findAttribute("name1")+"";
  String name2 = pageContext.findAttribute("name2")+"";
  String name3 = pageContext.findAttribute("name3")+"";
  String name4 = pageContext.findAttribute("name4")+"";
  String name5 = pageContext.findAttribute("name5")+"";//不存在
//    EL表达式输出最快,从底层到高层 page->request->session->application->null,即应用->扩展类->RT.jar包是往上寻找往下使用
//  JVM,双亲委派机制

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
