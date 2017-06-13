package com.rupeng.test;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {
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
		if(action.equals("addnew"))
		{
			List<MinZuInfo> minzus = new MinZuDAO().getAll();
			req.setAttribute("minzus", minzus);//给到jsp中的民族下拉列表显示所有民族使用
			
			req.getRequestDispatcher("/StudentAddNew.jsp").forward(req, resp);
		}
		else if(action.equals("addnewSubmit"))
		{
			String name = RupengUtils.getParameter(req, "name");
			/*boolean gender = Boolean.parseBoolean(req.getParameter("gender"));*/
			boolean gender = "male".equals(req.getParameter("gender"));
			String birthDay = req.getParameter("birthDay");
			Date dateBirthDay =Date.valueOf(birthDay);
			int classId = Integer.parseInt(req.getParameter("classId"));
			boolean teChangSheng = "on".equalsIgnoreCase(req.getParameter("teChangSheng"));
			int minZuId = Integer.parseInt(req.getParameter("minZuId"));
			
			StudentInfo student = new StudentInfo();
			student.setName(name);
			student.setGender(gender);
			student.setBirthDay(dateBirthDay);
			student.setClassId(classId);
			student.setTeChangSheng(teChangSheng);
			student.setMinZuId(minZuId);
			
			StudentDAO dao = new StudentDAO();
			dao.addnew(student);
			resp.sendRedirect("student?action=list");
		}
		else if(action.equals("edit"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			StudentDAO dao = new StudentDAO();
			StudentInfo student = new StudentInfo();
			student=dao.getById(id);
			if(student==null)
			{
				RupengUtils.showError(req, resp, "没有查询到id="+id+"的学生");
			}
			else
			{
				List<MinZuInfo> minzus = new MinZuDAO().getAll();
				req.setAttribute("minzus", minzus);//给到jsp中的民族下拉列表显示所有民族使用
				req.setAttribute("student", student);   
				req.getRequestDispatcher("/StudentEdit.jsp").forward(req, resp);	
				
			}
		}
		else if(action.equals("editSubmit"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			String name = RupengUtils.getParameter(req, "name");
			boolean gender = "male".equals(req.getParameter("gender"));
			String birthDay = req.getParameter("birthDay");
			Date dateBirthDay =Date.valueOf(birthDay);
			int classId = Integer.parseInt(req.getParameter("classId"));
			boolean teChangSheng = "on".equalsIgnoreCase(req.getParameter("teChangSheng"));
			int minZuId = Integer.parseInt(req.getParameter("minZuId"));
			
			StudentInfo student = new StudentInfo();
			student.setId(id);
			student.setName(name);
			student.setGender(gender);
			student.setBirthDay(dateBirthDay);
			student.setClassId(classId);
			student.setTeChangSheng(teChangSheng);
			student.setMinZuId(minZuId);
			
			StudentDAO dao = new StudentDAO();
			dao.update(student);
			resp.sendRedirect("student?action=list");
		}
		else if(action.equals("delete"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			StudentDAO dao = new StudentDAO();
			dao.delete(id);
			resp.sendRedirect("student?action=list");
		}
		else if(action.equals("list"))
		{
			StudentDAO dao = new StudentDAO();
			List<StudentInfo> list = dao.getAll();
			req.setAttribute("student", list);
			req.getRequestDispatcher("/StudentList.jsp").forward(req, resp);
		}
		else
		{
			RupengUtils.showError(req, resp, "错误的action:"+action);
		}
	}
}
