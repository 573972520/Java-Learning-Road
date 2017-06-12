package com.rupeng.test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.core.ChooseTag;

public class ELTest3Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("age", 3);
		req.setAttribute("name", "rupeng");
		req.setAttribute("nickName", "mhahah");
		
		List<String> names = new LinkedList<String>();
		/*names.add("carl");
		names.add("carl");*/
		req.setAttribute("names", names);
		
		String[] names2  = {"aduoh2","23904hd"};
		
		req.getRequestDispatcher("/ELTest3.jsp").forward(req, resp);
		
	}
}
