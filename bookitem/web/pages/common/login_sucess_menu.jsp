<%--
  Created by IntelliJ IDEA.
  User: waili
  Date: 2022/7/17
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="../order/order.jsp">我的订单</a>
    <a href="../../UserServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="../../index.jsp">返回</a>
</div>
