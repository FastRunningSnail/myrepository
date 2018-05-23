package com.entor.uims.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entor.uims.domain.User;
import com.entor.uims.service.UserService;

@WebServlet("/useredit")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();   
    
    public UserEditServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取参数
		String userid = request.getParameter("userid");
		// 2.获取用户信息
		User user = userService.getUserById(userid);
		// 3.将user保存到request中
		request.setAttribute("user", user);
		// 4.请求转发到editUser.jsp
		request.getRequestDispatcher("userEdit.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置编码
		request.setCharacterEncoding("utf-8");
		// 2.获取参数
		String userid = request.getParameter("userid");
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String authority = request.getParameter("authority");
		// 3.根据id修改信息
		User user = new User();
		user.setId(Integer.parseInt(userid));
		user.setLoginName(loginname);
		user.setPassword(password);
		user.setRealName(realname);
		user.setAuthority(Integer.parseInt(authority));
		userService.updateUser(user);
		// 4.设置当前session信息
		HttpSession session = request.getSession();
		session.setAttribute("loginname", loginname);
		session.setAttribute("realname", realname);
		// 6.返回编辑页面
		request.setAttribute("user", user);
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("userEdit.jsp").forward(request, response);
	}
}
