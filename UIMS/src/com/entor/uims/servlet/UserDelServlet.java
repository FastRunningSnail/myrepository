package com.entor.uims.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entor.uims.service.UserService;

@WebServlet("/userdel")
public class UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public UserDelServlet() {
		super();
	}

	// 单个用户删除
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取userid
		String userid = request.getParameter("userid");
		// 2.根据assert删除用户
		userService.deleteUser(userid);
		// 3.跳转到userList页面
		response.sendRedirect("userList");
	}

	// 批量删除
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获得待删除的userid
		String[] userids = request.getParameterValues("userids");
		System.out.println(Arrays.toString(userids));
		// 2.批量删除
		userService.batchDel(userids);
		// 3.删除成功返回列表页
		response.sendRedirect("userList");
	}

}
