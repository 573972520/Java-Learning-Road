package com.rupeng.test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ELTestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("age", 50);
		req.setAttribute("name", "hello a>b<c>d");
		Person p1 = new Person();
		p1.setId(5);
		p1.setAge(50);
		p1.setName("Tom");
		
		Person p2 = new Person();
		p2.setId(5);
		p2.setAge(14);
		p2.setName("jerry");
		
		List<Person> list = new LinkedList<Person>();
		list.add(p1);
		list.add(p2);
		
		req.setAttribute("person", list);
		req.getRequestDispatcher("/ELTest1.jsp").forward(req, resp);
		
		
		
		
		
	}
}
