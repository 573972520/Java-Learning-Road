package com.zsz.front.Utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontUtils {
	public static void showError(HttpServletRequest req,HttpServletResponse resp,String errorMsg) throws ServletException, IOException
	{
		resp.setStatus(500);
		req.setAttribute("errorMsg", errorMsg);
		req.getRequestDispatcher("/WEB/INF/error.jsp").forward(req, resp);
	}
	
	/**
	 * 设置当前登录用户ID
	 * @param req
	 * @param id
	 */
	public static void setCurrentUserId(HttpServletRequest req,long id)
	{
		req.getSession().setAttribute("CurrentUserId", id);
	}
	
	/**
	 * 获取当前登录用户ID(可能为null)
	 * @param req
	 * @return
	 */
	public static long getCurrentUserId(HttpServletRequest req)
	{
		Long id = (Long)req.getSession().getAttribute("CurrentUserId");
		return id;
	}
	
}
