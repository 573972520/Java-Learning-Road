package com.rupeng.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUserInfoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = RuPengUtils.getParameter(req, "username");
		UserInfo u = UserDAO.getByUserName(username);
		if(u == null)
		{
			resp.getWriter().print("error");
		}
		else
		{
			String s = u.getAge()+","+u.getEmail()+","+u.getPhoneNum();
			resp.getWriter().print(s);
		}
		
	}
}
