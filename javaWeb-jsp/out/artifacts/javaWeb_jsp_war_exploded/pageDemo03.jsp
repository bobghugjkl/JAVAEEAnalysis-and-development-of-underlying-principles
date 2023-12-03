<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//  第三个填作用域
  pageContext.setAttribute("hello1","hello1",pageContext.SESSION_SCOPE);//等价与session.setAttribute(...)......
%>
</body>
</html>
