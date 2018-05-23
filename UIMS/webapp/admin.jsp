<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>易唐用户管理系统-后台</title>
<link rel="stylesheet" type="text/css" href="css/admin.css">
</head>
<body>
	<div class="header">
		<a href="admin.jsp" class="logo">Entor Admin</a>
		<ul class="float_r">
			<li class="float_l">你好，<a href="userinfo?userid=${userid }"
				target="show">${realname }</a></li>
			<li class="float_l"><a>|</a></li>
			<li class="float_l"><a href="logout">退出</a></li>
		</ul>
	</div>
	<div class="float_clear"></div>
	<div class="body">
		<div class="menu float_l">
			<ul>
				<li><a href="alterName.jsp" target="show">修改姓名</a></li>
				<li><a href="alterPass.jsp" target="show">修改密码</a></li>
				<li><a href="userinfo?userid=${userid }" target="show">查看信息</a></li>
				<li><a href="userList" target="show">管理用户</a></li>
			</ul>
		</div>
		<div class="show float_r">
			<!-- iframe页面框架 -->
			<iframe name="show" frameborder="0" scrolling="no"
				style="width: 100%; height: 100%; border-left: 1px solid #4C4C4C;"></iframe>
		</div>
	</div>
	<div class="float_clear"></div>
	<div class="footer">
		<p>
			Copyright RAS ADMIN. All Right Reserved. More Templates <a
				href="http://www.entor.com.cn">易唐科技</a>
		</p>
	</div>
</body>
</html>