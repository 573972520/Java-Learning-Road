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
		if(RuPengUtils.isNullOrEmpty(action))
		{
			req.getRequestDispatcher("/StudentAjax.jsp").forward(req, resp);
			
		}
		else if(action.equals("getAll"))
		{
			RuPengUtils.initAjaxResponse(resp);
			StudentDAO studentDao = new StudentDAO();
			List<StudentInfo> students =  studentDao.getAll();
			AjaxResult result = new AjaxResult();
			result.setErrorCode("ok");
			result.setData(students);
			resp.getWriter().print(result.toString());
		}
		else if(action.equals("deleteById"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			new StudentDAO().delete(id);
			AjaxResult result = new AjaxResult();
			result.setErrorCode("ok");
			resp.getWriter().print(result.toString());
		}
		else if(action.equals("addnewSubmit"))
		{
			try {
				Thread.sleep(2020);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			AjaxResult result = new AjaxResult();
			try
			{
				String name = req.getParameter("name");
				String gender = req.getParameter("gender");
				String birthDay = req.getParameter("birthDay");
				String classId = req.getParameter("classId");
				String minZuId = req.getParameter("minZuId");
				String teChangSheng = req.getParameter("teChangSheng");
				
				StudentInfo student = new StudentInfo();
				student.setName(name);
				student.setGender("male".equals(gender));
				student.setBirthDay(Date.valueOf(birthDay));
				student.setClassId(Integer.parseInt(classId));
				student.setTeChangSheng(Boolean.parseBoolean(teChangSheng));
				student.setMinZuId(Integer.parseInt(minZuId));
				
				new StudentDAO().addnew(student);
				result.setErrorCode("ok");
			}
			catch(Exception e)
			{
				result.setErrorCode("error");
				result.setData(e.getMessage());
			}
			
			RuPengUtils.initAjaxResponse(resp);
			resp.getWriter().print(result.toString());
		}
		else if(action.equals("getById"))
		{
			RuPengUtils.initAjaxResponse(resp);
			
			int id = Integer.parseInt(req.getParameter("id"));
			StudentInfo stu = new StudentDAO().getById(id);
			AjaxResult result = new AjaxResult();
			
			if(stu == null)
			{
				result.setErrorCode("isNotFound");
			}
			else
			{
				result.setErrorCode("ok");
				result.setData(stu);
			}
			resp.getWriter().print(result.toString());
		}
		else if(action.equals("editSubmit"))
		{
			RuPengUtils.initAjaxResponse(resp);
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String gender = req.getParameter("gender");
			String birthDay = req.getParameter("birthDay");
			String classId = req.getParameter("classId");
			String minZuId = req.getParameter("minZuId");
			String teChangSheng = req.getParameter("teChangSheng");
			
			StudentInfo student = new StudentInfo();
			student.setId(id);
			student.setName(name);
			student.setGender("male".equals(gender));
			student.setBirthDay(Date.valueOf(birthDay));
			student.setClassId(Integer.parseInt(classId));
			student.setTeChangSheng(Boolean.parseBoolean(teChangSheng));
			student.setMinZuId(Integer.parseInt(minZuId));
			
			new StudentDAO().update(student);
			AjaxResult result = new AjaxResult();
			result.setErrorCode("ok");
			resp.getWriter().print(result.toString());
		}
		
	}
}
