package com.rupeng.test1;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class RuPengUtils extends HttpServlet {
	/**
	 * ��req��ȡ������ΪparamName��ֵ���Զ�����������������
	 * @param req
	 * @param paramName
	 * @return ������Ĳ���ֵ
	 */
	public static String getParameter (HttpServletRequest req,String paramName)
	{
		try
		{
			String value = req.getParameter(paramName);//
			byte[] bytes = value.getBytes("ISO-8859-1");
			return new String(bytes,"UTF-8");
		}
		catch(UnsupportedEncodingException ex)
		{
			throw new RuntimeException(ex);
		}
		
		
	}
}
