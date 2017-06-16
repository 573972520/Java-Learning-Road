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
				RuPengUtils.showError(req, resp, "�û���������д��");
				return;
			}
			if(RuPengUtils.isNullOrEmpty(password))
			{
				RuPengUtils.showError(req, resp, "���������д��");
				return;
			}
			if(RuPengUtils.isNullOrEmpty(yzm))
			{
				RuPengUtils.showError(req, resp, "��֤�������д��");
				return;
			}
			UserInfo user = UserDAO.getByUserName(username);
			if(user == null)
			{
				RuPengUtils.showError(req, resp, "�û���������");
				return;
			}
			if(!user.getPassword().equals(password))
			{
				RuPengUtils.showError(req, resp, "���벻��ȷ");
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
			//��Ϊ��������û�����JS����ֱ�ӷ���Http�����ĵȷ��������������
			//������Ȼ����������˺Ϸ��Լ�飬���Ƿ������˼����Ȼ�ز�����
			//ǰ�˵�JS�����Ϊ�˷����û����������˵ļ����"��������"
			
			if(RuPengUtils.isNullOrEmpty(username))
			{
				RuPengUtils.showError(req, resp, "�û���������д��");
				return;
			}
			if(RuPengUtils.isNullOrEmpty(password))
			{
				RuPengUtils.showError(req, resp, "���������д��");
				return;
			}
			if(!password2.equals(password))
			{
				RuPengUtils.showError(req, resp, "����������������һ��");
				return;
			}
			if(RuPengUtils.isNullOrEmpty(yzm))
			{
				RuPengUtils.showError(req, resp, "��֤�������д��");
				return;
			}
			//�Ƚ��û��������֤���Ƿ��session�е�һ��
			//��֤��ŵ�session�У�ֻ�з���������֪����ȷ����֤����ʲô
			String yzmInSession = (String)req.getSession().getAttribute("YZM");
			if(!yzmInSession.equals(yzm))
			{
				RuPengUtils.showError(req, resp, "��֤����д����");
				return;
			}
			//todo:�����֤���Ƿ���ȷ
			UserDAO.addNew(username, password);
			resp.sendRedirect("user?action=login");
		}
		else if(action.equals("exit")) //�˳���¼
		{
			HttpSession session = req.getSession();
			session.invalidate();//����session����session�������
			resp.sendRedirect("user?action=login");
		}
		else
		{
			req.setAttribute("errorMsg", "action����");
			req.getRequestDispatcher("Error.jsp").forward(req, resp);
		}
			
	}
}
