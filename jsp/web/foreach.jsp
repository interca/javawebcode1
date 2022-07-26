<%@ page import="servlet.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: waili
  Date: 2022/7/16
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px red solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px red solid;
        }
    </style>
</head>
<body>
  <c:forEach begin="1" end="10" var="i">
      ${i}
  </c:forEach><br>

   <%
       List<Student> list=new ArrayList<>();
       for(int i=0;i<10;i++){
           list.add(new Student(20+i*2,"name"+i,18+i,"1234"+i));
       }
       request.setAttribute("stus",list);
   %>
  <table>
      <tr>
          <th>id</th>
          <th>姓名</th>
          <th>年龄</th>
          <th>电话</th>
      </tr>
<c:forEach items="${requestScope.stus}" var="stu">
        <tr>
            <th>${stu.id}</th>
            <th>${stu.name}</th>
            <th>${stu.age}</th>
            <th>${stu.phone}</th>
        </tr>

</c:forEach>
      <table/>

</body>
</html>
