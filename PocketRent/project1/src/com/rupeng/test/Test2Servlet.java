package com.rupeng.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test2")
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		if(action.equals("view"))
		{
			request.getRequestDispatcher("WEB-INF/Test2.jsp").forward(request, response);
		}
		else if(action.equals("submit"))
		{
			String name = request.getParameter("name");
			//System.out.println(name);
			if(name.equals("admin")) 
			{
				response.getWriter().println("ok");
			}
			else
			{
				response.getWriter().println("error");
			}
		}
		else
		{
			response.getWriter().println("action错误");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
