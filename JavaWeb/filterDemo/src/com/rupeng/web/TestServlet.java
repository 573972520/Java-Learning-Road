package com.rupeng.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("testServlet开始处理业务逻辑");
		System.out.println(request.getParameter("a"));
		
		
		//目的：让服务器创建出session，以便测试session的钝化和活化
		HttpSession session =  request.getSession();
		
		User user = new User();
		user.setName("carl");
		user.setAge(12);
		session.setAttribute("user", user);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
