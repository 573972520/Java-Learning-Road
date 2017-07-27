package com.zsz.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsz.dto.CityDTO;
import com.zsz.dto.UserDTO;
import com.zsz.front.Utils.FrontUtils;
import com.zsz.service.CityService;
import com.zsz.service.UserService;
import com.zsz.tools.AjaxResult;

@WebServlet("/Index")
public class IndexServlet extends BaseServlet {

	public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CityService cityService = new CityService();
		CityDTO[] cities = cityService.getAll();
		
		req.setAttribute("cities", cities);
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		
	}
	
	//获取当前用户的城市信息
	public void queryCurrentCity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long userId = FrontUtils.getCurrentUserId(req);
		Long cityId=null;
		if(userId != null)
		{
			UserDTO user = new UserService().getById(userId);
			cityId = user.getCityId();
		}
		
		//如果当前没有用户登录或者登录用户的cityId为null，则cityId都会为null
		CityService cityService = new CityService();
		String cityName;
		if(cityId == null)
		{
			cityName = cityService.getAll()[0].getName();//如果没有当前城市。则认为第一个城市是当前城市
		}
		else
		{
			cityName = cityService.getById(cityId).getName();
			
		}
		writeJson(resp, new AjaxResult("ok","",cityName));
		
	}	
	public void getAllCities(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CityService cityService = new CityService();
		CityDTO[] cities = cityService.getAll();
		writeJson(resp, new AjaxResult("ok","",cities));
	}
		
	
		
}
