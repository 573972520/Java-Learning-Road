package com.rupeng.test;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TeacherServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		if(action.equals("addnew"))
		{
			request.getRequestDispatcher("/TeacherAddNew.jsp").forward(request, response);	
		}
		else if(action.equals("addnewSubmit"))
		{
			String name = RupengUtils.getParameter(request, "name");
			String phoneNum = request.getParameter("phoneNum");
			String birthDay = request.getParameter("birthDay");
			Date dateBirthDay =Date.valueOf(birthDay);//��2008-08-08�������ַ�������ΪDate����
			
			TeacherInfo teacher = new TeacherInfo();
			teacher.setName(name);
			teacher.setBirthDay(dateBirthDay);
			teacher.setPhoneNum(phoneNum);
			
			//������һ��SQL��䣬������һ����Jdbc��صĶ���
			//��Servlet�в�����Jdbc��������SQL���
			//JDBC��SQL��������DAO��
			
			//���ڸ��ӵ���Ŀ������DAO���ô�����������ɸ����Ը�ǿ
			TeacherDAO dao = new TeacherDAO();
			dao.addnew(teacher);
			response.sendRedirect("teacher?action=list");
		}
		else if(action.equals("edit"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			//�Ȳ�ѯ�޸�ǰ������
			TeacherDAO dao = new TeacherDAO();
			TeacherInfo teacher = new TeacherInfo();
			teacher=dao.getById(id);
			if(teacher==null)
			{
				/*request.setAttribute("msg", "û�в�ѯ��id="+id+"����ʦ");
				request.getRequestDispatcher("/Error.jsp").forward(request, response);*/
				RupengUtils.showError(request, response, "û�в�ѯ��id="+id+"����ʦ");
			}
			else
			{
				request.setAttribute("teacher", teacher);   
				request.getRequestDispatcher("/TeacherEdit.jsp").forward(request, response);	
			}
		}
		else if(action.equals("editSubmit"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String name = RupengUtils.getParameter(request, "name");
			String phoneNum = request.getParameter("phoneNum");
			String birthDay = request.getParameter("birthDay");
			Date dateBirthDay =Date.valueOf(birthDay);
			
			TeacherInfo teacher = new TeacherInfo();
			
			teacher.setId(id);
			teacher.setName(name);
			teacher.setBirthDay(dateBirthDay);
			teacher.setPhoneNum(phoneNum);
			
			TeacherDAO dao = new TeacherDAO();
			dao.update(teacher);
			response.sendRedirect("teacher?action=list");
		}
		else if(action.equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			/*TeacherDAO dao = new TeacherDAO();
			dao.delete(id);*/
			new TeacherDAO().delete(id);
			response.sendRedirect("teacher?action=list");
		}
		else if(action.equals("list"))
		{
			TeacherDAO dao = new TeacherDAO();
			List<TeacherInfo> list = dao.getAll();
			request.setAttribute("teachers", list);   /*���д����TeacherList.jsp�е�<c:forEach items="${teachers }" >��Ӧ��ʹ֮�ó����е�����*/
			request.getRequestDispatcher("/TeacherList.jsp").forward(request, response);
		}
		else
		{
			/*request.setAttribute("msg", "�����action:"+action);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);*/
			RupengUtils.showError(request, response, "�����action:"+action);
		}
		
		/*
		DAO :Data Access Object
		1��Servlet�в��������ݿ���صĶ���
		2�������к����ݿ���صĶ����ŵ�DAO�У�Servletֻ��DAO�򽻵�
		3��Servlet��DAO֮�䴫�ݸ��������ö���
		
		DAO���ŵ㣺��˾��ְ
		Servlet���Ǹ�����û���������ȡ���󡢴������󡢷�����Ӧ����������������ô�����ݿ������ģ�Servlet����
		DAOֻ��������ݿ�򽻵���ȡ������������ô�ã�ΪʲôҪaddnewһ������DAO����
		*/
	}
}
