package com.rupeng.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.W3CDomHandler;

public class Person2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//persons2?action=list ��ʾ���е���Ա
		//persons2?action=addnew ��ʾ����ҳ��
		//persons2?action=edit&id=2 �༭idΪ2����Ա
		//persons2/action=addnewSubmit&name=yzk&age=18 �����ύ  ִ��SQL�е� Insert 
		//persons2/action=editSubmit&id=2&name=yzh&age=11 �༭�ύ  ִ��SQL�е� Update
		//persons2/action=delete&id=2 ɾ��idΪ2������
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		String action = req.getParameter("action");
		if(action.equals("list"))
		{
			writer.println("<html><head><meta charset='UTF-8'></head>");
			writer.println("<body>");
			writer.println("<p><a href='persons2?action=addnew'>����</a></p>");
			writer.println("<table>");
			writer.println("<thead><tr><td>Id</td><td>����</td><td>����</td></tr></thead>");
			writer.println("<tbody>");
			ResultSet rs = null;
			try {
				rs = JdbcUtils.executeQuery("select * from t_persons");
				while(rs.next())
				{
					int id = rs.getInt("Id");
					String name = rs.getString("Name");
					int age = rs.getInt("Age");
					writer.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td></tr>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				writer.print("��ѯ���ݿ����");
				e.printStackTrace();
			}
			finally
			{
				JdbcUtils.closeAll(rs);
			}
			
			writer.println("</tbody>");
			writer.println("</table>");
			writer.println("</body></html>");
		}
		else if(action.equals("addnew"))//��ʾ����ҳ��
		{
			resp.setContentType("text/html;charset=UTF-8");
			writer.println("<body>");
			writer.println("<form action='persons2' method='post'>");
			//��������Ȼ�ڽ����п����������Ǳ��ύ��ʱ�����ܹ��ύ����������
			//��<input type='hidden' name='action' value='addnewSubmit' />  �����÷�����֪����Ҫ��ʲô
			writer.println("<input type='hidden' name='action' value='addnewSubmit' />");
			writer.println("������<input type='text' name='name' />");
			writer.println("���䣺<input type='text' name='age' />");
			writer.println("<input type='submit' value='����' />");
			writer.println("</form>");
			writer.println("</body>");
		}
		else if(action.equals("edit")) 
		{
			
		}
		else if(action.equals("addnewSubmit")) //�û�������ҳ���е������Ĵ����߼�
		{
			String name = RuPengUtils.getParameter(req, "name");
			int age = Integer.parseInt(req.getParameter("age"));
			try {
				JdbcUtils.executeUpdate("Insert into t_persons(Name,Age) values(?,?)",
										name,age);
			} catch (SQLException e) {
				writer.println("�����������");
				e.printStackTrace();
			}
			resp.sendRedirect("persons2?action=list");//����ɹ�֮���ض��򵽲�ѯҳ�棬�����Ϳ���������������������
		}
		else if(action.equals("editSubmit"))
		{
			
		}
		else if(action.equals("delete"))
		{
			
		}
		
		else
		{
			
		}
		
		
	}
}
