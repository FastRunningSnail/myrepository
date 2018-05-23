<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	width: 80%;
	margin: 0 auto;
	text-align: center;
}

table {
	width: 80%;
	margin: 0 auto;
}

table, th, td {
	border: 1px solid #4c4c4c;
	border-collapse: collapse;
}

.batch {
	text-align: left;
	margin-left: 110px;
}
</style>
</head>
<body>
	<h1>用户管理列表</h1>
	<form action="userdel" method="post">
		<div class="batch">
			<input type="submit" value="批量删除" onclick="return batchDel();">&emsp;<a href="userAdd.jsp">增加</a>
		</div>
		<table>
			<thead>
				<tr>
					<th><input type="checkbox"id="chooseAll"
						onclick="chooseEach(this);">全选</th>
					<th>序号</th>
					<th>用户id</th>
					<th>登录名</th>
					<th>姓名</th>
					<th>创建日期</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList }" var="user" varStatus="status">
					<tr>
						<td><input type="checkbox" class="choosen" name="userids"
							value="${user.id }" onclick="choose(this);"></td>
						<td>${status.index + 1 }</td>
						<td>${user.id }</td>
						<td>${user.loginName }</td>
						<td>${user.realName }</td>
						<td>${user.createDate }</td>
						<td><a href="userinfo?userid=${user.id }">查看</a>|<a
							href="useredit?userid=${user.id }">编辑</a>|<a
							href="#" onclick="delUser(${user.id});">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<script type="text/javascript">
		// 单个删除
		function delUser(userid) {
			if (confirm('确认删除吗？')) {
				window.location.href = 'userdel?userid=' + userid;
			}
		}
		// batch批量删除
		function batchDel() {
			if (countChoosen() == 0) {
				alert("请勾选要删除的记录...");
				return false;
			}
			return confirm("确认删除吗？");
		}
		// 单选
		function choose(that) {
			var choosen = document.getElementsByClassName("choosen");
			if (countChoosen() < choosen.length) {
				// 没有全部选中
				document.getElementById('chooseAll').checked = false;
			} else {
				// 全部选中
				document.getElementById('chooseAll').checked = true;
			}
		}
		// 全选
		function chooseEach(that) {
			var choosen = document.getElementsByClassName("choosen");
			if (that.checked) {// 全选
				for (var i = 0; i < choosen.length; i++) {
					choosen[i].checked = true;
				}
			} else {// 取消全选
				for (var i = 0; i < choosen.length; i++) {
					choosen[i].checked = false;
				}
			}
		}
		// 选中计数
		function countChoosen() {
			var choosen = document.getElementsByClassName("choosen");
			var count = 0;
			for (var i = 0; i < choosen.length; i++) {
				if (choosen[i].checked)
					count++;
			}
			return count;
		}
	</script>
</body>
</html>