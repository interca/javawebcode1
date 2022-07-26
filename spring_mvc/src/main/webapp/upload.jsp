<%--
  Created by IntelliJ IDEA.
  User: waili
  Date: 2022/7/25
  Time: 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/user/quick13" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br/>
    上传文件<input type="file" name="uploadFile">
    <input type="submit" name="按钮">
</form>
</body>
</html>
