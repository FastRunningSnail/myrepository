package com.entor.uims.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entor.uims.domain.User;
import com.entor.uims.service.UserService;

@WebServlet("/userinfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public UserInfoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.接收userid
		String userid = request.getParameter("userid");
		// 2.根据id查找用户信息
		User user = userService.getUserById(userid);
		// 3.将用信息保存到request中
		request.setAttribute("user", user);
		// 4.响应页面（请求转发）
		request.getRequestDispatcher("userinfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
