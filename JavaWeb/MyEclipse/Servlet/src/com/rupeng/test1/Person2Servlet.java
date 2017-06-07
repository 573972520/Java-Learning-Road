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
		//persons2?action=list 显示所有的人员
		//persons2?action=addnew 显示新增页面
		//persons2?action=edit&id=2 编辑id为2的人员
		//persons2/action=addnewSubmit&name=yzk&age=18 新增提交  执行SQL中的 Insert 
		//persons2/action=editSubmit&id=2&name=yzh&age=11 编辑提交  执行SQL中的 Update
		//persons2/action=delete&id=2 删除id为2的数据
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		String action = req.getParameter("action");
		if(action.equals("list"))
		{
			writer.println("<html><head><meta charset='UTF-8'></head>");
			writer.println("<body>");
			writer.println("<p><a href='persons2?action=addnew'>新增</a></p>");
			writer.println("<table>");
			writer.println("<thead><tr><td>Id</td><td>姓名</td><td>年龄</td></tr></thead>");
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
				writer.print("查询数据库出错");
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
		else if(action.equals("addnew"))//显示新增页面
		{
			resp.setContentType("text/html;charset=UTF-8");
			writer.println("<body>");
			writer.println("<form action='persons2' method='post'>");
			//隐藏域虽然在界面中看不到，但是表单提交的时候是能够提交给服务器的
			//放<input type='hidden' name='action' value='addnewSubmit' />  就是让服务器知道我要干什么
			writer.println("<input type='hidden' name='action' value='addnewSubmit' />");
			writer.println("姓名：<input type='text' name='name' />");
			writer.println("年龄：<input type='text' name='age' />");
			writer.println("<input type='submit' value='保存' />");
			writer.println("</form>");
			writer.println("</body>");
		}
		else if(action.equals("edit")) 
		{
			
		}
		else if(action.equals("addnewSubmit")) //用户在新增页面中点击保存的处理逻辑
		{
			String name = RuPengUtils.getParameter(req, "name");
			int age = Integer.parseInt(req.getParameter("age"));
			try {
				JdbcUtils.executeUpdate("Insert into t_persons(Name,Age) values(?,?)",
										name,age);
			} catch (SQLException e) {
				writer.println("新增保存出错");
				e.printStackTrace();
			}
			resp.sendRedirect("persons2?action=list");//保存成功之后重定向到查询页面，这样就可以立即看到新增的数据
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
