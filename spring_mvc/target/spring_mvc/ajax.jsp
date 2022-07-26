<%--
  Created by IntelliJ IDEA.
  User: waili
  Date: 2022/7/24
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script>
        var userList=new Array();
        userList.push({username:"zhangsan",age:29})
        userList.push({username:"lis",age:19})
        $.ajax({
            type :"POST",
            url:"${pageContext.request.contextPath}/user/quick10",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"

        })

    </script>
</head>
<body>

</body>
</html>
