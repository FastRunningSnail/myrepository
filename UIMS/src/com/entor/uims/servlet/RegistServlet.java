package com.entor.uims.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entor.uims.domain.User;
import com.entor.uims.service.UserService;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public RegistServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应的编码格式
		response.setContentType("text/html;charset=utf-8");
		// 获取响应内容输出对象
		PrintWriter out = response.getWriter();
		out.write("<h1>注册不支持get方式请求，请回到注册页面！</h1>");
		out.flush();// 刷新输出流，将数据推送到浏览器
		out.close();// 关闭输出流
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求参数的编码格式
		request.setCharacterEncoding("utf-8");
		// 获取注册参数
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String authority = request.getParameter("authority");

		// 设置响应的编码格式
		response.setContentType("text/html;charset=utf-8");
		// 获取响应内容输出对象
		PrintWriter out = response.getWriter();

		// 判断用户是否存在
		if (userService.isLoginNameExist(loginname)) {
			out.write("<h1>用户名已存在！</h1>");
			out.flush();// 刷新输出流，将数据推送到浏览器
			out.close();// 关闭输出流
			return;// 结束当前逻辑的执行
		}

		// 封装注册参数
		User user = new User();
		user.setLoginName(loginname);
		user.setPassword(password);
		user.setRealName(realname);
		user.setAuthority(Integer.parseInt(authority));

		// 调用保存用户的逻辑
		userService.saveUser(user);

		out.write("<h1>注册成功！5秒后跳转到登陆界面</h1>");
		out.write("<script>setTimeout('window.location.href=\"login.html\"',3000)</script>");
		out.flush();// 刷新输出流，将数据推送到浏览器
		out.close();// 关闭输出流
	}

}
