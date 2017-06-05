package com.rupeng.test1;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo2Servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		int i = Integer.parseInt(req.getParameter("i"));
		int j = Integer.parseInt(req.getParameter("j"));
		int r = i*j;				
		resp.getWriter().print(r);
		
		//String haha = req.getParameter("haha");
		String[] hahas = req.getParameterValues("haha");
		resp.getWriter().print("<br/>");
		resp.getWriter().print(Arrays.toString(hahas));
		
		String cb1 = req.getParameter("cb1");
		if(cb1==null)
		{
			resp.getWriter().print("is not vip");
		}
		else if(cb1.equals("on"))
		{
			resp.getWriter().print(" vip");
		}
		
		String cb2 = req.getParameter("cb2");
		if(cb2==null)
		{
			resp.getWriter().print("bushi waiji");
		}
		else if(cb2.equals("on"))
		{
			resp.getWriter().print("shi waiji");
		}
	}
}
