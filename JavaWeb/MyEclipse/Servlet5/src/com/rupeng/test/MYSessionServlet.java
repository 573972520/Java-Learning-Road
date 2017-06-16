package com.rupeng.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MYSessionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String action = req.getParameter("action");
		MySession session = new MySession(req, resp);
		if(action.equals("read"))
		{
			String un = session.getAttribute("UserName");
			String yzm = session.getAttribute("yzm");
			
			resp.getWriter().println("un="+un+";yzm="+yzm);
		}
		else if(action.equals("write"))
		{
			session.setAttribute("UserName", "hahaha");
			session.setAttribute("yzm", "aaccee");
		}
	}
	
}
