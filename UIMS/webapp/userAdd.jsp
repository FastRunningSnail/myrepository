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
	<form action="useradd" method="post">
		<select name="authority">
			<option value="1">普通用户</option>
			<option value="2">管理员</option>
		</select><br> &emsp;&emsp;帐号：<input class="text" type="text" name="loginname"> <br>
		&emsp;&emsp;密码：<input class="text" type="password" name="password"> <br>
		&emsp;&emsp;姓名：<input class="text" type="text" name="realname"> <br>
		<input class="btn" type="submit" value="添加">
	</form>
</body>
<script type="text/javascript">
	function alter() {
		var oldpass = document.getElementById('loginname').value;
		var password = document.getElementById('password').value;
		var repass = document.getElementById('realname').value;

		if (oldpass == null || oldpass == undefined || oldpass == '') {
			alert('账号不能为空！');
			return false;
		}

		if (password == null || password == undefined || password == '') {
			alert('密码不能为空！');
			return false;
		}

		if (realname == null || realname == undefined || realname == '') {
			alert('姓名不能为空！');
			return false;
		}
		
	}
</script>
</html>