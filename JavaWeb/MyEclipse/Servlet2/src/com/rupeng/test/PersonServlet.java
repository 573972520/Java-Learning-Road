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
				//ResultSet等一般不要传给jsp
				req.setAttribute("persons", list);//request中的数据有效期是"当期请求"
				//jsp中就可以从request中取出"persons"的值
				req.getRequestDispatcher("/PersonList2.jsp").forward(req, resp);
				//让PersonList2.jsp进行数据的显示
			} catch (SQLException e) {
				resp.getWriter().write("数据库查询错误");
				e.printStackTrace();
			}
		}
		else if(action.equals("addnew"))
		{
			//MVC中的用户不直接和JSP打交道（地址栏中不会出现jsp），JSP只是负责
			//req.getRequestDispatcher("/PersonList2.jsp").forward(req, resp);
			//之后数据的显示，用户永远和普通的Servlet打交道
			
			//由PersonAddNew帮我处理
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
				req.setAttribute("msg", "插入数据执行失败");//把jsp要用的数据放到request中
				
				//如果逻辑是由服务器处理的，那么"/"一般可以表示"项目的WebRoot根目录(http://volcano:8080/Servlet2/)"
				//req.getRequestDispatcher("/MyError.jsp").forward(req, resp);
				//如果逻辑是由浏览器处理的，那么/"一般可以表示"http://volcano:8080"
				//resp.sendRedirect("/MyError.jsp");
				
				
				//forward和sendRedir的区别
				
				//让"MyError.jsp"去显示数据
				req.getRequestDispatcher("/MyError.jsp").forward(req, resp);
				
				//resp.sendRedirect("MyError.jsp");
				//如果写成sendRedirect，那么浏览器是发出两次请求的，两次请求中request的数据不能共享
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
					req.setAttribute("msg", "没有找到id="+id+"的人员");
					req.getRequestDispatcher("/MyError.jsp").forward(req, resp);
				}
				JdbcUtils.closeAll(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				req.setAttribute("msg", "数据库查询出错");
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
				req.setAttribute("msg", "保存出错");
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
				req.setAttribute("msg", "删除出错");
				req.getRequestDispatcher("/MyError.jsp").forward(req, resp);
			}
		}
				
		//浏览器和普通的Servlet打交道，jsp只是负责数据的显示
		//Servlet用req.getRequestDispatcher("/MyError.jsp").forward(req, resp);来负责把数据给到jsp中去显示
		
		
		//总结
		//用户不直接访问jsp，而是和Servlet打交道
		//Servlet把数据准备好，然后forward给jsp去显示
		//Servlet和JSP直接传递数据，不传递ResultSet等，而是传递对象或者对象的集合
		
		//MVC的目的：
		//让Controller（Servlet）负责数据的收集、数据的处理、查询等
		//View(JSP)负责数据的展示。
		//这样在Servlet中不用进行html的拼接了，使代码逻辑更加清晰
		
}
}

