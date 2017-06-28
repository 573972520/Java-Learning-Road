package com.rupeng.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class Test1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("age", 5);
		req.setAttribute("name", "haha");
		String[] strs = {"abc","123","haha"};
		req.setAttribute("strs", strs);
		
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		req.setAttribute("list", list);
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1,"tom"));
		persons.add(new Person(2,"lily"));
		persons.add(new Person(3,"poly"));
		req.setAttribute("persons", persons);
		
		req.setAttribute("stuId", 2);
		
		req.getRequestDispatcher("/WEB-INF/Test1.jsp").forward(req, resp);
		
		int[] nums = {3,5,8};
	}
}
