<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<base href="http://localhost:8080/bookitem/pages/client/index.jsp">
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
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<%-- 如果没有显示登录，显示登录信息，否则显示用户信息--%>
				<c:if test="${empty sessionScope.user}">
					<a href="../../pages/user/login.jsp">登录</a> |
					<a href="../../pages/user/regist.jsp">注册</a>
				</c:if>

				<c:if test="${not empty sessionScope.user}">
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
					<a href="../order/order.jsp">我的订单</a>
					<a href="../../UserServlet?action=logout">注销</a>&nbsp;&nbsp;
				</c:if>
				<a href="../../pages/cart/cart.jsp">购物车</a>
				<a href="../../pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>

	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="" method="get">
					价格：<input id="min" type="text" name="min" value=""> 元 - 
						<input id="max" type="text" name="max" value=""> 元 
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有3件商品</span>
				<div>
					您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
				</div>
			</div>

			<c:forEach items="${requestScope.page.items}" var="book">
			<div class="b_list">
				<div class="img_div">

					<img class="book_img" alt="" src="../../${book.imgPath}" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button>加入购物车</button>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>


		<div id="page_nav">
			<%--  如果当前页面大于一才有上一页--%>
			<c:if test="${requestScope.page.pageNo>1}">
				<a href="../../client/bookServlet?action=page&pageNo=1">首页</a>
				<a href="../../client/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>
			<a href="">3</a>
			【${requestScope.page.pageNo}】
			<a href="#">5</a>
			<%--  如果当前页面小于总页数才有下一页和末页--%>
			<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="../../client/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="../../client/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
			</c:if>
			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
			<input id="searchPageBtn" type="button" value="确定">
			<script type="text/javascript">
				//跳到指定的页面
				$(function (){
					$("#searchPageBtn").click(function (){
						var pageNo=$("#pn_input").val()
						location.href="http://localhost:8080/bookitem/client/bookServlet?action=page&pageNo="+pageNo;
					})
				})
			</script>
		</div>

	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>