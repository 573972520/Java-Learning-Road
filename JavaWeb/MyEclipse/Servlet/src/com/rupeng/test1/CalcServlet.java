package com.rupeng.test1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int i1 = Integer.parseInt(req.getParameter("i1"));
		int i2 = Integer.parseInt(req.getParameter("i2"));
		String op = req.getParameter("op");
		int r; 
		if(op.equals("+"))
		{
			r = i1+i2;
		}
		else if(op.equals("-"))
		{
			r = i1-i2;
		}
		else if(op.equals("x"))
		{
			r = i1*i2;
		}
		else
		{
			r=0;
		}
		resp.getWriter().print(r);
			
	}
}
