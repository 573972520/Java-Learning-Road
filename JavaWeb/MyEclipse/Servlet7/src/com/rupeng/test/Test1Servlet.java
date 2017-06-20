package com.rupeng.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1Servlet extends HttpServlet {
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
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("test1");
		out.print("</body>");
		out.print("</html>");
		
		//resp.sendRedirect("test2");
		//req.getRequestDispatcher("/2.html").forward(req, resp);
		//req.getRequestDispatcher("/test2").forward(req, resp);
		req.getRequestDispatcher("/test2").include(req, resp);
		req.getRequestDispatcher("/2.html").include(req, resp);
		
	}
}
