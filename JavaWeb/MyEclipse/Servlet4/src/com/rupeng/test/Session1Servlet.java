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
			//�ŵ��������ڴ���
			req.getSession().setAttribute("�������","�ضȾ���");
			req.getSession().setAttribute("age",8);
		}
		else if(action.equals("read"))
		{
			String obj = (String)req.getSession().getAttribute("�������");
			if(obj != null)
			{
				resp.getWriter().println(obj);
			}
			else
			{
				resp.getWriter().println("�޼������");
			}
			Integer age = (Integer)req.getSession().getAttribute("age");
			if(age != null)
			{
				resp.getWriter().println(age);
			}
			else
			{
				resp.getWriter().println("������");
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
