<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入核心标签库才可以使用--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>if测试</h4>
<form action="coreif.jsp" method="get">
    <%--    EL表达式获取表单中的数据${param.参数名}--%>
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="登录">
</form>
<%--判断如果提交的用户名是管理员那么登陆成功--%>
<c:if test="${param.username == 'admin'}" var="a=isAdmin">
    <c:out value="welcome"></c:out>

</c:if>
<c:out value="${isAdmin}"></c:out>
</body>
</html>
