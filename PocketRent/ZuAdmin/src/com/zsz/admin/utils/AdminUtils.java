package com.zsz.admin.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminUtils {
	public static void showError(HttpServletRequest req,HttpServletResponse resp,String errorMag) 
		   throws ServletException, IOException
	{
		req.setAttribute("errorMag", errorMag);
		req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
	}
	public static void setAdminUserId(HttpServletRequest req,long adminUserId)
	{
		req.getSession().setAttribute("AdminUserId", adminUserId);
	}
	public static void setAdminUserCityId(HttpServletRequest req,Long CityId)
	{
		req.getSession().setAttribute("AdminUserCityId", CityId);
	}
	/**
	 * 获取当前登录用户的id，如果返回null则表示取不到
	 * @param req
	 * @param adminUserId
	 * @return
	 */
	public static Long getAdminUserId(HttpServletRequest req)
	{
		Long id = (Long)req.getSession().getAttribute("AdminUserId");
		return id;
	}
	/**
	 * 获取当前登录用户的城市id，如果返回null则表示取不到
	 * @param req
	 * @param CityId
	 * @return
	 */
	public static Long getAdminUserCityId(HttpServletRequest req)
	{
		Long id = (Long)req.getSession().getAttribute("AdminUserCityId");
		return id;
	}
	
	
}
