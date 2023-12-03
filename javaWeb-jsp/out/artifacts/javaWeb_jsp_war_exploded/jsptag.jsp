<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--携带参数访问网址--%>
    <jsp:forward page="/jsptag2.jsp">
        <jsp:param name="name" value="value1"/>
        <jsp:param name="age" value="value2"/>
    </jsp:forward>
</body>
</html>
