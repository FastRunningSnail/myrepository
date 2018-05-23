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

@WebServlet("/alterName")
public class AlterNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService=new UserService();   
    public AlterNameServlet() {
        super();
        }

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
		request.setCharacterEncoding("utf-8");
		//2.获取参数
		String userid = request.getParameter("userid");
		String oldname = request.getParameter("oldname");
		String realname = request.getParameter("realname");
		//System.out.println("userid:"+userid);
		//3.判断姓名是否存在
		boolean result = userService.isNameExist(userid,oldname);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(!result){
			out.write("修改失败，旧姓名不存在！");
			out.flush();
			out.close();
			return;
		}
		//4.根据id更新姓名
		userService.updateNameById(userid,realname);
		//5.重新设置session中的姓名
		HttpSession session = request.getSession();
		session.setAttribute("realname", realname);
		out.write("<script>window.parent.location.href='admin.jsp'</script>");
		out.flush();
		out.close();
	}

}
