<%--
  Created by IntelliJ IDEA.
  User: waili
  Date: 2022/7/20
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="http://localhost:8080/cookiie/LoginServlet" method="get">
      用户名<input type="text" name="username" value="${cookie.username.value}"><br>
      密码<input type="password" name="password">
      <input type="submit" value="登录">
  </form>
</body>
</html>
