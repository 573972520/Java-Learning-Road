package com.rupeng.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RupengUtils {
	
	/**
	 * 从请求中获取名字为name的值，解决中文乱码问题
	 * @param req
	 * @param name
	 * @return
	 */
	public static String getParameter(HttpServletRequest req, String name)
	{
		try
		{
			String value = req.getParameter(name);
			byte[] bytes;
			bytes = value.getBytes("ISO-8859-1");
			return new String(bytes,"UTF-8");
		}
		catch(UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 在Error.jsp中显示错误消息
	 * @param request
	 * @param response
	 * @param msg
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void showError(HttpServletRequest request,HttpServletResponse response,String msg) throws ServletException, IOException
	{
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/Error.jsp").forward(request, response);
	}
	
}
