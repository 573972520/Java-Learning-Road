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
		//resp.setContentType("application/json"); //��JqueryAjax5.html�е� dataType:"json"һ����Ч��
		Gson gson = new Gson();
		String s = gson.toJson(result); //��������������ֶΣ�����json�ַ���
		resp.getWriter().print(s);
		//resp.getWriter().print("ok"); ����趨��dataType:"json"�������صĲ���json��ʽ,���ǻ�error
	}
}
