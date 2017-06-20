package com.rupeng.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;

public class RuPengUtils {
	
	public static String getParameter(HttpServletRequest req,String name)
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
	
	public static void showError(HttpServletRequest req,HttpServletResponse resp,String msg) throws ServletException, IOException
	{
		req.setAttribute("errorMsg", msg);
		req.getRequestDispatcher("/Error.jsp").forward(req, resp);
	}
	
	/**
	 * 判断一个字符是否是null或者是否是长度为0 的字符串
	 * @param s
	 * @return
	 */
	public static boolean isNullOrEmpty(String s)
	{
		return s==null || s.length() <= 0;
	}
	
	/**
	 * 设置返回Ajax的响应的ContentType以及编码
	 * @param resp
	 */
	public static void initAjaxResponse(HttpServletResponse resp)
	{
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
	}
	
	
	/**
	 * 从files找到fieldName为fieldName的DiskFileItem
	 * @param files
	 * @param fieldName
	 * @return 如果没找到就返回null
	 */
	public static FileItem findDiskFileItem(List<FileItem> files,String fieldName)
	{
		for(FileItem file : files)
		{
			if(file.getFieldName().equals(fieldName))
			{
				return file;
			}
		}
		return null;
	}
}
