<%--
  Created by IntelliJ IDEA.
  User: 15071
  Date: 2018/4/10
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${msg}</title>
</head>
<body>
<h1>${msg}</h1>
<h1>${name}</h1>
<form action="home" method="post">
    <input type="text" name="username" placeholder="请输入用户名"/>
    <br>
    <input type="password" name="password" placeholder="请输入密码"/>
    <button type="submit">提交</button>
</form>
</body>
</html>
