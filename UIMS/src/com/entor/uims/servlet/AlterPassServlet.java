package com.entor.uims.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entor.uims.service.UserService;

@WebServlet("/alterPass")
public class AlterPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserService();
	
    
    public AlterPassServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.设置编码
		request.setCharacterEncoding("utf-8");
		// 2.获取参数
		String userid = request.getParameter("userid");
		String oldpass = request.getParameter("oldpass");
		String password = request.getParameter("password");
		// 3.判断密码是否存在
		boolean result = userService.isPassExist(userid, oldpass);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (!result) {
			out.write("修改失败，旧密码不存在！");
			out.flush();
			out.close();
			return;
		}
		// 4.根据id更新密码
		userService.updatePassById(userid, password);
		// 5.清空当前session信息
		HttpSession session = request.getSession();
		session.removeAttribute("userid");
		session.removeAttribute("loginname");
		session.removeAttribute("realname");
		// 6.刷新admin.jsp
		out.write("<script>window.parent.location.href='login.html'</script>");
		out.flush();
		out.close();
	}

}
