<%--
  Created by IntelliJ IDEA.
  User: waili
  Date: 2022/8/4
  Time: 6:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>展示账户数据</h1>
<table border="1">
    <tr>
        <th>账户id</th>
        <th>账户名称</th>
        <th>账户金额</th>
    </tr>

    <c:forEach items="${accountList1}" var="account">
        <tr>
            <th>${account.id}</th>
            <th>${account.name}</th>
            <th>${account.money}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
