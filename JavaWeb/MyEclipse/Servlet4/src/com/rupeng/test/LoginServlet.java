package com.rupeng.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
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
		if(action == null || action.length() <= 0)
		{
			Cookie[] cookies = req.getCookies();
			if(cookies != null){
				for(Cookie cookie : req.getCookies())
				{
					if(cookie.getName().equals("LoginUserName"))
					{
						String username = cookie.getValue();
						req.setAttribute("LoginUserName", username);
					}
				}
			}
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
		else
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if(password.equals("123"))
			{
				Cookie cookieUserName = new Cookie("LoginUserName",username);
				resp.addCookie(cookieUserName);
				resp.sendRedirect("cookie1?action=read");
			}
			else
			{
				resp.getWriter().println("errror");
			}
				
			
		}
	}
}
