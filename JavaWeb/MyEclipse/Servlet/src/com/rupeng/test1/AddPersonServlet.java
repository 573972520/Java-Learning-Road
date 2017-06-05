package com.rupeng.test1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPersonServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//������ݿ��д������룬���������£�
		//1 ��ȡ����������ǲ�������
		//2 ���ݿ������ַ��������ݿɿ�������Ƿ�����
		String name = RuPengUtils.getParameter(req, "name");
		String nickName = RuPengUtils.getParameter(req, "nickName");
		int age = Integer.parseInt(req.getParameter("age"));
		//boolean isTuHao = req.getParameter("isTuHao").equals("on");
		boolean isTuHao = "on".equals(req.getParameter("isTuHao")); //����ѡ�ѡ��ʱ��ֵΪnull���ʹ�������Ĵ���������NullPointerException����
		String major = req.getParameter("major");
		String xqx = req.getParameter("xqx");
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			JdbcUtils.executeUpdate("Insert into T_Persons(Name,NickName,Age,isTuHao,Major,XQX) values(?,?,?,?,?,?)",
									name,nickName,age,isTuHao,major,xqx);
		resp.getWriter().print("����ɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
			resp.getWriter().print("���ݿ�ִ��ʧ��");
		}
		
				
				
		
	}
}
