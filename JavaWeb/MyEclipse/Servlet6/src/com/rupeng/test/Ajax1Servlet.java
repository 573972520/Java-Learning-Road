package com.rupeng.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ajax1Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if(action == null || action.length() < 0)
		{
			req.getRequestDispatcher("/Ajax1.jsp").forward(req, resp);
		}
		else if(action.equals("add"))
		{
			int i = Integer.parseInt(req.getParameter("i"));
			int j = Integer.parseInt(req.getParameter("j"));
			resp.setContentType("text/html");
			resp.getWriter().println(i+j);
		}
	}
}
