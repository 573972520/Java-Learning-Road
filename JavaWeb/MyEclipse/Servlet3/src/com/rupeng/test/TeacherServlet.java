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
			Date dateBirthDay =Date.valueOf(birthDay);//将2008-08-08这样的字符串解析为Date类型
			
			TeacherInfo teacher = new TeacherInfo();
			teacher.setName(name);
			teacher.setBirthDay(dateBirthDay);
			teacher.setPhoneNum(phoneNum);
			
			//看不到一行SQL语句，看不到一个和Jdbc相关的东西
			//在Servlet中不出现Jdbc，不出现SQL语句
			//JDBC、SQL语句出现在DAO中
			
			//对于复杂的项目，引入DAO会让代码更清晰，可复用性更强
			TeacherDAO dao = new TeacherDAO();
			dao.addnew(teacher);
			response.sendRedirect("teacher?action=list");
		}
		else if(action.equals("edit"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			//先查询修改前的数据
			TeacherDAO dao = new TeacherDAO();
			TeacherInfo teacher = new TeacherInfo();
			teacher=dao.getById(id);
			if(teacher==null)
			{
				/*request.setAttribute("msg", "没有查询到id="+id+"的老师");
				request.getRequestDispatcher("/Error.jsp").forward(request, response);*/
				RupengUtils.showError(request, response, "没有查询到id="+id+"的老师");
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
			request.setAttribute("teachers", list);   /*这行代码和TeacherList.jsp中的<c:forEach items="${teachers }" >对应，使之拿出其中的数据*/
			request.getRequestDispatcher("/TeacherList.jsp").forward(request, response);
		}
		else
		{
			/*request.setAttribute("msg", "错误的action:"+action);
			request.getRequestDispatcher("/Error.jsp").forward(request, response);*/
			RupengUtils.showError(request, response, "错误的action:"+action);
		}
		
		/*
		DAO :Data Access Object
		1、Servlet中不出现数据库相关的东西
		2、把所有和数据库相关的东西放到DAO中，Servlet只和DAO打交道
		3、Servlet和DAO之间传递复杂数据用对象
		
		DAO的优点：各司其职
		Servlet就是负责和用户交互（获取请求、处理请求、返回响应），到底数据是怎么跟数据库搞出来的，Servlet不管
		DAO只负责和数据库打交道，取出来的数据怎么用，为什么要addnew一条数据DAO不管
		*/
	}
}
