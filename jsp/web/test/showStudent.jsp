<%@ page import="java.util.List" %>
<%@ page import="servlet.Student" %><%--
  Created by IntelliJ IDEA.
  User: waili
  Date: 2022/7/14
  Time: 23:00
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

<%
    List<Student>list= (List<Student>) request.getAttribute("stuList");

%>
     <table>
         <%for(Student student:list){%>
          <tr>
              <td><%=student.getId()%></td>
              <td><%=student.getName()%></td>
              <td><%=student.getAge()%></td>
              <td><%=student.getPhone()%></td>
          </tr>
         <%}%>
     </table>
</body>
</html>
