package com.rupeng.test;

import java.awt.Label;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String action = req.getParameter("action");
		if(action.equals("list"))
		{
			try {
				ResultSet rs = JdbcUtils.executeQuery("select * from t_persons");
				List<Person> list = new LinkedList<Person>();
				while(rs.next())
				{
					int id = rs.getInt("Id");
					String name = rs.getString("Name");
					int age = rs.getInt("Age");
					Person p  = new Person();
					p.setId(id);
					p.setName(name);
					p.setAge(age);
					list.add(p);
				}
				//ResultSet��һ�㲻Ҫ����jsp
				req.setAttribute("persons", list);//request�е�������Ч����"��������"
				//jsp�оͿ��Դ�request��ȡ��"persons"��ֵ
				req.getRequestDispatcher("/PersonList2.jsp").forward(req, resp);
				//��PersonList2.jsp�������ݵ���ʾ
			} catch (SQLException e) {
				resp.getWriter().write("���ݿ��ѯ����");
				e.printStackTrace();
			}
		}
		else if(action.equals("addnew"))
		{
			//MVC�е��û���ֱ�Ӻ�JSP�򽻵�����ַ���в������jsp����JSPֻ�Ǹ���
			//req.getRequestDispatcher("/PersonList2.jsp").forward(req, resp);
			//֮�����ݵ���ʾ���û���Զ����ͨ��Servlet�򽻵�
			
			//��PersonAddNew���Ҵ���
			req.getRequestDispatcher("/PersonAddNew.jsp").forward(req, resp);
		}
		else if(action.equals("addnewSubmit"))
		{
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			
			try {
				JdbcUtils.executeUpdate("insert into t_persons(Name,Age) values(?,?)", name,age);
				resp.sendRedirect("person?action=list");
			} catch (SQLException e) {
				req.setAttribute("msg", "��������ִ��ʧ��");//��jspҪ�õ����ݷŵ�request��
				
				//����߼����ɷ���������ģ���ô"/"һ����Ա�ʾ"��Ŀ��WebRoot��Ŀ¼(http://volcano:8080/Servlet2/)"
				//req.getRequestDispatcher("/MyError.jsp").forward(req, resp);
				//����߼��������������ģ���ô/"һ����Ա�ʾ"http://volcano:8080"
				//resp.sendRedirect("/MyError.jsp");
				
				
				//forward��sendRedir������
				
				//��"MyError.jsp"ȥ��ʾ����
				req.getRequestDispatcher("/MyError.jsp").forward(req, resp);
				
				//resp.sendRedirect("MyError.jsp");
				//���д��sendRedirect����ô������Ƿ�����������ģ�����������request�����ݲ��ܹ���
			}
			
			
		}
		else if(action.equals("edit"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				ResultSet rs = JdbcUtils.executeQuery("select * from t_persons where Id=?", id);
				if(rs.next())
				{
					Person person = new Person();
					person.setId(id);
					person.setName(rs.getString("Name"));
					person.setAge(rs.getInt("Age"));
					req.setAttribute("person", person);
					req.getRequestDispatcher("/PersonEdit.jsp").forward(req, resp);
				}
				else
				{
					req.setAttribute("msg", "û���ҵ�id="+id+"����Ա");
					req.getRequestDispatcher("/MyError.jsp").forward(req, resp);
				}
				JdbcUtils.closeAll(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				req.setAttribute("msg", "���ݿ��ѯ����");
				req.getRequestDispatcher("/MyError.jsp").forward(req, resp);
			}
			
		}
		else if(action.equals("editSubmit"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			try {
				JdbcUtils.executeUpdate("Update t_persons set Name=?,Age=? where Id=?",name,age,id);
				resp.sendRedirect("person?action=list");
			} catch (SQLException e) {
				req.setAttribute("msg", "�������");
				req.getRequestDispatcher("/MyError.jsp").forward(req, resp);
			}
		}
		else if(action.equals("delete"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				JdbcUtils.executeUpdate("delete from t_persons where Id=?",id);
				resp.sendRedirect("person?action=list");
			} catch (SQLException e) {
				req.setAttribute("msg", "ɾ������");
				req.getRequestDispatcher("/MyError.jsp").forward(req, resp);
			}
		}
				
		//���������ͨ��Servlet�򽻵���jspֻ�Ǹ������ݵ���ʾ
		//Servlet��req.getRequestDispatcher("/MyError.jsp").forward(req, resp);����������ݸ���jsp��ȥ��ʾ
		
		
		//�ܽ�
		//�û���ֱ�ӷ���jsp�����Ǻ�Servlet�򽻵�
		//Servlet������׼���ã�Ȼ��forward��jspȥ��ʾ
		//Servlet��JSPֱ�Ӵ������ݣ�������ResultSet�ȣ����Ǵ��ݶ�����߶���ļ���
		
		//MVC��Ŀ�ģ�
		//��Controller��Servlet���������ݵ��ռ������ݵĴ�����ѯ��
		//View(JSP)�������ݵ�չʾ��
		//������Servlet�в��ý���html��ƴ���ˣ�ʹ�����߼���������
		
}
}

