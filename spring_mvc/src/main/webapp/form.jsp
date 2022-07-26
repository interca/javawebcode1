<%--
  Created by IntelliJ IDEA.
  User: waili
  Date: 2022/7/24
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <form action="${pageContext.request.contextPath}/user/quick9" method="post">
        <!--第几个user对象的值-->
       <input type="text" name="userList[0].username">
       <input type="text" name="userList[0].age">
       <input type="text" name="userList[1].username">
       <input type="text" name="userList[1].age">
       <input type="submit">
   </form>
</body>
</html>
