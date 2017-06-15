package com.rupeng.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Session2Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String action = req.getParameter("action");
		if(action.equals("login"))
		{
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
		else if(action.equals("loginSubmit"))
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if(password.equals("123"))
			{
				//把当前登录用户的用户名写入session
				req.getSession().setAttribute("UserName", username);
				resp.sendRedirect("session2?action=main");
			}
			else
			{
				resp.getWriter().println("error");
			}
		}
		else if(action.equals("main"))
		{
			//从Session中读取"登录用户名"
			String username = (String)req.getSession().getAttribute("UserName");
			//如果读不到，则说明用户没有登录上,重定向到登录页面，这样实现了登录才能访问的功能
			if(username == null)
			{
				resp.sendRedirect("session2?action=login");
			}
			else
			{
				//把当前登录用户的用户名给到Main.jsp中显示
				//req.setAttribute("UserName", username);
				req.getRequestDispatcher("Main.jsp").forward(req, resp);
			}
		}
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
