<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/11/26
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  ArrayList<String> people = new ArrayList<>();
  people.add(0,"0");
  people.add(1,"1");
  request.setAttribute("list",people);
%>
<c:forEach var="people" items="${list}">
  <c:out value="${people}"/> <br>
</c:forEach>
</body>
</html>
