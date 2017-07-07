package com.zsz.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if(StringUtils.isEmpty(action) || action.equals("index"))
		{
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		}
		
		else if(action.equals("login"))
		{
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
