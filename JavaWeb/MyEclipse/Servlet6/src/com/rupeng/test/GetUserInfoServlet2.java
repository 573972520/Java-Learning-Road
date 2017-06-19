package com.rupeng.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class GetUserInfoServlet2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = RuPengUtils.getParameter(req, "username");
		UserInfo u = UserDAO.getByUserName(username);
		AjaxResult result = new AjaxResult();
		
		if(u == null)
		{
			result.setErrorCode("error");
		}
		else
		{
			result.setErrorCode("ok");
			result.setData(u);
		}
		//resp.setContentType("application/json"); //和JqueryAjax5.html中的 dataType:"json"一样的效果
		Gson gson = new Gson();
		String s = gson.toJson(result); //遍历对象的所有字段，生成json字符串
		resp.getWriter().print(s);
		//resp.getWriter().print("ok"); 如果设定了dataType:"json"，而返回的不是json格式,则还是会error
	}
}
