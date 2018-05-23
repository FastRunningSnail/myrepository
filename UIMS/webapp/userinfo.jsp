<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>userid:${user.id}</h1>
<h1>loginname:${user.loginName}</h1>
<h1>realname:${user.realName}</h1>
<h1>authority:${user.authority eq 1 ? '普通用户' : '管理员'}</h1>
<h1>createdate:${user.createDate}</h1>

 