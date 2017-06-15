package com.rupeng.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Session1Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String action = req.getParameter("action");
		if(action.equals("write"))
		{
			//放到服务器内存中
			req.getSession().setAttribute("鉴定结果","重度精神病");
			req.getSession().setAttribute("age",8);
		}
		else if(action.equals("read"))
		{
			String obj = (String)req.getSession().getAttribute("鉴定结果");
			if(obj != null)
			{
				resp.getWriter().println(obj);
			}
			else
			{
				resp.getWriter().println("无鉴定结果");
			}
			Integer age = (Integer)req.getSession().getAttribute("age");
			if(age != null)
			{
				resp.getWriter().println(age);
			}
			else
			{
				resp.getWriter().println("无年龄");
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
