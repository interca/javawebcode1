<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>

<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
	<script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>

	<script type="text/javascript">
		//页面加载完成之后
		$(function (){
			//给注册绑定单机事件
          $("#sub_btn").click(function (){
			  //由字母下划线组成，长度5—到12位.获取输入框中的内容
			  var usernametext=$("#username").val();
			  var patt=/^\w{5,12}$/   //正则表达式对象
			  if(!patt.test(usernametext)){
				  $("span.errorMsg").text("用户名不合法");
				  return false;
			  }

			  //密码
			  var passswordtext=$("#password").val();
			  var paswordpatt=/^\w{5,12}$/   //正则表达式对象
			  if(!paswordpatt.test(passswordtext)){
				  $("span.errorMsg").text("密码格式错误");
				  return false;
			  }

			  //确认密码
			  var repwdtext=$("#repwd").val()//获取内容,再和密码比较
			  if(repwdtext!=passswordtext){
				  $("span.errorMsg").text("密码不符合")
				  return false
			  }

			  //邮箱验证
			  var emailtext=$("#email").val();
			  //获取邮箱内容，创建正则表达式对象，然后在匹配一样吗
			  var emailpatt=/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
              if(!emailpatt.test(emailtext)){
				  $("span.errorMsg").text("邮箱不合法")
				  return false;
			  }

			  //验证码
			  var code=$("#code").val()
			  //去掉前后空格
			  code=$.trim(code)
			  if(code==null||code==""){
				  $("span.errorMsg").text("验证码为空")
			  }
			  //合法要去掉,恢复
			  $("span.errorMsg").text();
		  })
		})
	</script>

<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
								</span>
							</div>
							<div class="form">
								<form action="http://localhost:8080/bookitem/UserServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
									value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"
									value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 150px;" id="code"/>
									<img alt="" src="../../static/img/code.bmp" style="float: right; margin-right: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/foot.jsp"%>
</body>
</html>