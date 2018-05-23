package com.entor.uims.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entor.uims.domain.User;
import com.entor.uims.service.UserService;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  UserService userService =new UserService();
	
    public UserListServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取全部用户信息
		List<User> userList = userService.getAllUsers();
		System.out.println("userList:"+userList.size());
		// 2.保存用户信息
		request.setAttribute("userList", userList);
		// 3.请求转发给userList.jsp
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
