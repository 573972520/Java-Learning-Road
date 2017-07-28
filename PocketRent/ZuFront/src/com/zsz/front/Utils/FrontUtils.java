package com.zsz.front.Utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsz.dto.UserDTO;
import com.zsz.service.CityService;
import com.zsz.service.UserService;

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
	
	//获得当前城市Id（依次从“当前登录用户”、“session”、“第一个城市”中获取）
	public static long getCurrentCityId(HttpServletRequest req)
	{
		Long userId = FrontUtils.getCurrentUserId(req);
		Long cityId=null;
		if(userId != null) 
		{
			UserDTO user = new UserService().getById(userId);
			cityId = user.getCityId();
			if(cityId != null)
			{
				return cityId;
			}
		}
		
		//如果当前没有用户登录或者登录用户的cityId为null，则cityId都会为null
		cityId = (Long)req.getSession().getAttribute("CurrentCityId");
		if(cityId != null)
		{
			return cityId;
		}
		
		//如果没人登录，而且session也没有CityId，则用第一个城市做当前城市
		CityService cityService = new CityService();
		return cityService.getAll()[0].getId();
	}
	
	public static void setCurrentCityId(HttpServletRequest req,long cityId)
	{
		Long userId = FrontUtils.getCurrentUserId(req);
		if (userId != null)// 如果有用户登录，则更新用户的CityId
		{
			UserService userService = new UserService();
			userService.setUserCityId(userId, cityId);// 设置登录用户的CityId
		} 
		else  // 如果没人登录，则把城市id保存到Session中
		{
			req.getSession().setAttribute("CurrentCityId", cityId);
		}
	}
	
}