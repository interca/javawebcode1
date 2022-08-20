<%--
  Created by IntelliJ IDEA.
  User: waili
  Date: 2022/8/4
  Time: 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>添加账户页面</h1>
<form name="accountFrom" action="${pageContext.request.contextPath}/account/save" method="post">
    账户名称<input type="text" name="name"><br>
    账户金额<input type="text" name="money"><br>
    <input type="submit" value="保存"><br>
</form>
</body>
</html>
