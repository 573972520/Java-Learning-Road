package com.rupeng.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClassServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action.equals("getAll"))
		{
			List<ClassInfo> classes = new ClassDAO().getAll();
			AjaxResult result = new AjaxResult();
			result.setErrorCode("ok");
			result.setData(classes);
			RuPengUtils.initAjaxResponse(resp);
			resp.getWriter().print(result.toString());
			
		}
	}
}
