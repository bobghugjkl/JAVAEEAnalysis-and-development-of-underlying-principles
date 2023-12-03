<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--定义一个变量score--%>
<c:set var="score" value="85"/>

<c:choose>
  <c:when test="${score>=90}">
    great!
  </c:when>
  <c:when test="${score>=80}">
    no bad!
  </c:when>
  <c:when test="${score<80}">
    6
  </c:when>
</c:choose>
</body>
</html>
