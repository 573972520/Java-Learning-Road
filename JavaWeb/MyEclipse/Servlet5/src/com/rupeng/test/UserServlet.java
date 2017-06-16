package com.rupeng.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		
		if(action.equals("login"))
		{
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
		else if(action.equals("loginSubmit"))
		{
			String username = RuPengUtils.getParameter(req, "username");
			String password = req.getParameter("password");
			String yzm = req.getParameter("yzm");
			if(RuPengUtils.isNullOrEmpty(username))
			{
				RuPengUtils.showError(req, resp, "用户名必须填写！");
				return;
			}
			if(RuPengUtils.isNullOrEmpty(password))
			{
				RuPengUtils.showError(req, resp, "密码必须填写！");
				return;
			}
			if(RuPengUtils.isNullOrEmpty(yzm))
			{
				RuPengUtils.showError(req, resp, "验证码必须填写！");
				return;
			}
			UserInfo user = UserDAO.getByUserName(username);
			if(user == null)
			{
				RuPengUtils.showError(req, resp, "用户名不存在");
				return;
			}
			if(!user.getPassword().equals(password))
			{
				RuPengUtils.showError(req, resp, "密码不正确");
				return;
			}
			req.getSession().setAttribute("UserName", username);
			resp.sendRedirect("main");
		}
		else if(action.equals("register"))
		{
		req.getRequestDispatcher("Register.jsp").forward(req, resp);
		}
		else if(action.equals("registerSubmit"))
		{
			String username = RuPengUtils.getParameter(req, "username");
			String password = req.getParameter("password");
			String password2 = req.getParameter("password2");
			String yzm = req.getParameter("yzm");
			//因为浏览器有用户禁用JS或者直接发生Http请求报文等方法来跳过表单检查
			//所以虽然浏览器端做了合法性检查，但是服务器端检查任然必不可少
			//前端的JS检查是为了方便用户，服务器端的检查是"防范坏人"
			
			if(RuPengUtils.isNullOrEmpty(username))
			{
				RuPengUtils.showError(req, resp, "用户名必须填写！");
				return;
			}
			if(RuPengUtils.isNullOrEmpty(password))
			{
				RuPengUtils.showError(req, resp, "密码必须填写！");
				return;
			}
			if(!password2.equals(password))
			{
				RuPengUtils.showError(req, resp, "两次输入的密码必须一致");
				return;
			}
			if(RuPengUtils.isNullOrEmpty(yzm))
			{
				RuPengUtils.showError(req, resp, "验证码必须填写！");
				return;
			}
			//比较用户输入的验证码是否和session中的一致
			//验证码放到session中，只有服务器才能知道正确的验证码是什么
			String yzmInSession = (String)req.getSession().getAttribute("YZM");
			if(!yzmInSession.equals(yzm))
			{
				RuPengUtils.showError(req, resp, "验证码填写错误！");
				return;
			}
			//todo:检查验证码是否正确
			UserDAO.addNew(username, password);
			resp.sendRedirect("user?action=login");
		}
		else if(action.equals("exit")) //退出登录
		{
			HttpSession session = req.getSession();
			session.invalidate();//销毁session，把session数据清除
			resp.sendRedirect("user?action=login");
		}
		else
		{
			req.setAttribute("errorMsg", "action错误");
			req.getRequestDispatcher("Error.jsp").forward(req, resp);
		}
			
	}
}
