package com.zsz.admin.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zsz.admin.utils.AdminUtils;
import com.zsz.tools.AjaxResult;

public class BaseServlet extends HttpServlet {
	private static final Logger logger =LogManager.getLogger(BaseServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(StringUtils.isEmpty(action))
		{
			AdminUtils.showError(req, resp, "action is empty");
			//resp.getWriter().print("action is empty");
			logger.warn("action为空");
			return;
		}
		Class clz = this.getClass();  //Class是子类的Class , 不是BaseServlet
		//约定方法的名字就是 action的名字（req,resp）
		try {
			Method methodAction = clz.getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			//拿到了 	public void index(HttpServletRequest req,HttpServletResponse resp) 的方法
			methodAction.invoke(this, req,resp);
		} catch (NoSuchMethodException | SecurityException e) {
			AdminUtils.showError(req, resp, "cannot invoke action method"+action);
			//resp.getWriter().print("cannot invoke action method "+action);
			logger.warn("找不到名字为"+action+"的方法" , e);
		} catch(IllegalAccessException | IllegalArgumentException |InvocationTargetException e)
		{
			AdminUtils.showError(req, resp, "invoke method"+action+"error");
			//resp.getWriter().print("invoke method"+ action +" error");
			logger.warn("调用名字为"+action+"的方法失败" , e);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	protected void writeJson(HttpServletResponse resp, AjaxResult ajaxResult) throws IOException
	{
		resp.setContentType("application/json");
		resp.getWriter().print(ajaxResult.toJson());
	}
	
	
}
