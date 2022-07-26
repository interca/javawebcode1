<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<base href="http://localhost:8080/bookitem/pages/manager/book_manager.jsp">
	<script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
	<script>
		$(function() {
			//给删除的a标签绑定单机事件
			$("a.deleteClass").click(function () {
				//返回true事件继续，返回false结束事件
				return confirm("你确定要删除吗")
			})
		})
	</script>

<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
</head>
<body>
	
	<div id="header" >
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span  class="wel_word">图书管理系统</span>
		<div>
			<a href="../../manager/BookServlet?action=list">图书管理</a>
			<a href="order_manager.jsp">订单管理</a>
			<a href="../../index.jsp">返回商城</a>
		</div>

	</div>
	
	<div id="main">
		<table >
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="../../manager/BookServlet?action=getBook&id=${book.id}&method=update">修改</a></td>
					<td><a class="deleteClass" href="../../manager/BookServlet?action=delete&id=${book.id}">删除</a></td>
				</tr>
			</c:forEach>

			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="book_edit.jsp?method=add">添加图书</a></td>
			</tr>	
		</table>
		<div id="page_nav">
			<%--  如果当前页面大于一才有上一页--%>
			<c:if test="${requestScope.page.pageNo>1}">
				<a href="../../manager/BookServlet?action=page&pageNo=1">首页</a>
				<a href="../../manager/BookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>
			<a href="">3</a>
			【${requestScope.page.pageNo}】
			<a href="#">5</a>
				<%--  如果当前页面小于总页数才有下一页和末页--%>
			<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="../../manager/BookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="../../manager/BookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
			</c:if>
			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
			<input id="searchPageBtn" type="button" value="确定">
			<script type="text/javascript">
				//跳到指定的页面
				$(function (){
					$("#searchPageBtn").click(function (){
						var pageNo=$("#pn_input").val()
						location.href="http://localhost:8080/bookitem/manager/BookServlet?action=page&pageNo="+pageNo;
					})
				})
			</script>
		</div>

	</div>
	</div>
	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>