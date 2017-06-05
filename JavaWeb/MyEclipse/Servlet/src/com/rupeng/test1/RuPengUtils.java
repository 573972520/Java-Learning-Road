package com.rupeng.test1;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class RuPengUtils
{
	/**
	 * 从req中取出名字为paramName的值，自动处理参数乱吗的问题
	 * @param req
	 * @param paramName
	 * @return 不乱码的参数值
	 */
	public static String getParameter(HttpServletRequest req, String paramName)
	{
		try
		{
			String value = req.getParameter(paramName);// 先得到乱码的字符串
			byte[] bytes = value.getBytes("ISO-8859-1");
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
