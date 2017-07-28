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
		long cityId = FrontUtils.getCurrentCityId(req);
		String cityName = new CityService().getById(cityId).getName();
		writeJson(resp, new AjaxResult("ok","",cityName));
		
	}	
/*	public void getAllCities(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CityService cityService = new CityService();
		CityDTO[] cities = cityService.getAll();
		writeJson(resp, new AjaxResult("ok","",cities));
	}
		*/
	public void changeCity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long cityId = Long.parseLong(req.getParameter("cityId"));
		FrontUtils.setCurrentCityId(req, cityId);
		writeJson(resp, new AjaxResult("ok"));
	}
		
		
}
