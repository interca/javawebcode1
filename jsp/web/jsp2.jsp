<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: waili
  Date: 2022/7/15
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   保存之前${requestScope.abc}<br>
   <c:set scope="request" var="abc" value="1111"/>
   保存之后:${requestScope.abc}
</body>
</html>
