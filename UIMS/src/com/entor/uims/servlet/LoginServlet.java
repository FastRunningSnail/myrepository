package com.entor.uims.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entor.uims.domain.User;
import com.entor.uims.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();// servlet验证需要以来service

	public LoginServlet() {
		super();
	}

	// 处理来自浏览器的get方式请求
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应的编码格式
		response.setContentType("text/html;charset=utf-8");
		// 获取响应内容输出对象
		PrintWriter out = response.getWriter();
		out.write("<h1>登录不支持get方式请求，请回到登录页面登录本系统！</h1>");
		out.flush();// 刷新输出流，将数据推送到浏览器
		out.close();// 关闭输出流
	}

	// 处理来自浏览器的post方式请求
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求参数的编码格式
		request.setCharacterEncoding("utf-8");
		// 获取登录参数
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");

		// 设置响应的编码格式
		response.setContentType("text/html;charset=utf-8");

		// 传递给service进行验证
		boolean result = userService.validate(loginname, password);
		if (result) {
			// 登录成功
			// 1.获取session对象
			HttpSession session = request.getSession();
			// 2.获取用户信息
			User user = userService.getUserByLoginName(loginname);
			// 3.保存用户的id、loginname、realname
			session.setAttribute("userid", user.getId());
			session.setAttribute("loginname", user.getLoginName());
			session.setAttribute("realname", user.getRealName());
			// 4.跳转admin.jsp（重定向）
			response.sendRedirect("admin.jsp");
		} else {
			// 登录失败
			response.sendRedirect("login.html");
		}
	}

}
