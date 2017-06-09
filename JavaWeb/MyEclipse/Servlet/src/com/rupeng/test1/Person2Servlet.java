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
	public void init() throws ServletException {
		super.init();
		//��һ������Servlet��ʱ��init����������
		System.out.println("Person2Servlet��ʼ��");
		//ServletĬ���ǣ��ڷ�������ֻ����һ������
	}
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Person2Servlet����");
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String xing = getServletConfig().getInitParameter("xing");
		String ming = getServletConfig().getInitParameter("ming");
		System.out.println(xing);
		System.out.println(ming);
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
			writer.println("<thead><tr><td>Id</td><td>����</td><td>����</td><td>�༭</td><td>ɾ��</td></tr></thead>");
			writer.println("<tbody>");
			ResultSet rs = null;
			try {
				rs = JdbcUtils.executeQuery("select * from t_persons");
				while(rs.next())
				{
					int id = rs.getInt("Id");
					String name = rs.getString("Name");
					int age = rs.getInt("Age");
					writer.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td><a href='persons2?action=edit&id="+id+"'>�༭</a></td><td><a onclick='return confirm(\"ȷ��Ҫɾ����?\")' href='persons2?action=delete&id="+id+"'>ɾ��</a></td></tr>");
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
			writer.println("<html><head><meta charset='UTF-8'></head>");
			writer.println("<body>");
			int id = Integer.parseInt(req.getParameter("id"));
			ResultSet rs = null;
			try {
				rs = JdbcUtils.executeQuery("select * from t_persons where Id=?", id);
				if(rs.next())//�����һ�ε���next()�ͷ���false����˵��һ�����ݶ�û�У�������id=id������
				{
					String name = rs.getString("Name");
					int age = rs.getInt("Age");
					writer.println("<form action='persons2' method='post'>");
					writer.println("<input type='hidden' name='action' value='editSubmit' />");
					writer.println("<input type='hidden' name='id' value='"+id+"' />");//�÷�����֪��Ҫupdate˭
					//update * where Id=?
					writer.println("������<input type='text' name='name' value='"+name+"' />");
					writer.println("���䣺<input type='text' name='age' value='"+age+"' />");
					writer.println("<input type='submit' value='����' />");
					writer.println("</form >");
				}
				else
				{
					writer.println("û���ҵ�id="+id+"������");
				}
			} catch (SQLException e) {
				writer.println("��ѯ����");
				e.printStackTrace();
			}
			finally{
				JdbcUtils.closeAll(rs);
			}
			writer.println("</body></html>");
		}
		else if(action.equals("addnewSubmit")) //�û�������ҳ���е������Ĵ����߼�
		{
			String name = RuPengUtils.getParameter(req, "name");
			int age = Integer.parseInt(req.getParameter("age"));
			try {
				JdbcUtils.executeUpdate("Insert into t_persons(Name,Age) values(?,?)",
										name,age);
				resp.sendRedirect("persons2?action=list");//����ɹ�֮���ض��򵽲�ѯҳ�棬�����Ϳ���������������������
			} catch (SQLException e) {
				writer.println("�����������");
				e.printStackTrace();
			}
		}
		else if(action.equals("editSubmit"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			String name = RuPengUtils.getParameter(req, "name");
			int age = Integer.parseInt(req.getParameter("age"));
			try {
				JdbcUtils.executeUpdate("update t_persons set Name=?,Age=? where Id=?", name,age,id);
				resp.sendRedirect("persons2?action=list");
			} catch (SQLException e) {
				writer.println("�޸ı������");
				e.printStackTrace();
			}
		}
		else if(action.equals("delete"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				JdbcUtils.executeUpdate("delete from t_persons where Id=?", id);
				resp.sendRedirect("persons2?action=list");
			} catch (SQLException e) {
				writer.print("ɾ���������");
				e.printStackTrace();
			}
			
		}
		
		else
		{
			
			writer.print("δ֪����");
		}
		
		
	}
}
