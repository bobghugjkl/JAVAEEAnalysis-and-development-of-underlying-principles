<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //People people = new People()

%>
<jsp:useBean id="people" class="com.pojo.People" scope="page"/>
<jsp:setProperty name="people" property="address" value="x"/>
<jsp:getProperty name="people" property="address" />
</body>
</html>
