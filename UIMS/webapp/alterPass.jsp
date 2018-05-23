<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>修改密码</h1>
	<form action="alterPass" method="post">
		<input type="hidden" name="userid" value="${userid}"> 旧密码:<input
			type="password" name="oldpass" id="oldpass"> <br> 新密码:<input
			type="password" name="password" id="password"> <br>
		确认输入:<input type="password" name="repass" id="repass"> <br>
		<input type="submit" value="提交" onclick="return alter();">
	</form>
</body>
<script type="text/javascript">
	function alter() {
		var oldpass = document.getElementById('oldpass').value;
		var password = document.getElementById('password').value;
		var repass = document.getElementById('repass').value;

		if (oldpass == null || oldpass == undefined || oldpass == '') {
			alert('请输入旧密码！');
			return false;
		}

		if (password == null || password == undefined || password == '') {
			alert('请输入新密码！');
			return false;
		}

		if (password == oldpass) {
			alert('新密码不可与旧密码相同！');
			return false;
		}
		
		if (password != repass) {
			alert('两次输入的新密码不一致！');
			return false;
		}
	}
</script>
</html>