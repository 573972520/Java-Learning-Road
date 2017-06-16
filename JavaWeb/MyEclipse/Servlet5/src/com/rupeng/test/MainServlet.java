package com.rupeng.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String username = (String)req.getSession().getAttribute("UserName");
		if(username == null)
		{
			resp.sendRedirect("user?action=login");//�û�û�е�¼�����ܷ��ʣ����¼
			return;
		}
		resp.getWriter().println("hello"+username+"<a href='user?action=exit'>�˳�</a>");
	}
}
