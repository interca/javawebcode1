<%--
  Created by IntelliJ IDEA.
  User: waili
  Date: 2022/7/16
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <form action="http://localhost:8080/jsp/upload" method="post" enctype="multipart/form-data">
       用户名:<input type="text" name="username"><br>
       头像:<input type="file" name="photo">
       <input type="submit" value="上传">
   </form>

</body>
</html>
