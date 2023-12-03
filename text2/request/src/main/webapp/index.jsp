<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<h1>登录</h1>
<div>
<%--    写死的，这里表单表示一post的形式提交表单，提交到我们的login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        username:<input type="text" name="username"><br>
        password:<input type="password" name="password"><br>
        hobby:
        <input type="checkbox" name="hobbys" value="斋藤飞鸟">斋藤飞鸟
        <input type="checkbox" name="hobbys" value="生田绘梨花">生田绘梨花
        <input type="checkbox" name="hobbys" value="西野七濑">西野七濑
        <input type="checkbox" name="hobbys" value="白石麻衣">白石麻衣
        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>