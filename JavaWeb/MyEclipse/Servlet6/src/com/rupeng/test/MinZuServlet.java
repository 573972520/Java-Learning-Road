package com.rupeng.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MinZuServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action.equals("getAll"))
		{
			List<MinZuInfo> list = new MinZuDAO().getAll();
			AjaxResult result = new AjaxResult();
			result.setErrorCode("ok");
			result.setData(list);
			RuPengUtils.initAjaxResponse(resp);
			resp.getWriter().print(result.toString());
			
		}
	}
}
