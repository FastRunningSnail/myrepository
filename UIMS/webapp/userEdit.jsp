<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<p>${message }</p>
	<!-- 表单元素 -->
	<form action="useredit" method="post">
		<input type="hidden" name="userid" value="${user.id }"> <select
			name="authority">
			<option value="1">普通用户</option>
			<option value="2">管理员</option>
		</select> <br> &emsp;&emsp;帐号：<input class="text" type="text"
			name="loginname" value="${user.loginName }" readonly="readonly">
		<br> &emsp;&emsp;密码：<input class="text" type="text"
			name="password" value="${user.password }"> <br>
		&emsp;&emsp;姓名：<input class="text" type="text" name="realname"
			value="${user.realName }"> <br> <input class="btn"
			type="submit" value="更新">
	</form>
	<script type="text/javascript">
		// 给select列表赋值
		document.getElementsByTagName('select')[0].value = '${user.authority }';
	</script>
</body>
</html>