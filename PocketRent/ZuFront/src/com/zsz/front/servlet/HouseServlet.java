package com.zsz.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.zsz.dao.utils.HouseSearchResult;
import com.zsz.dto.AttachmentDTO;
import com.zsz.dto.HouseDTO;
import com.zsz.dto.HousePicDTO;
import com.zsz.dto.HouseSearchOptions;
import com.zsz.dto.RegionDTO;
import com.zsz.dto.HouseSearchOptions.OrderByType;
import com.zsz.front.Utils.FrontUtils;
import com.zsz.service.AttachmentService;
import com.zsz.service.CityService;
import com.zsz.service.HouseAppointmentService;
import com.zsz.service.HouseService;
import com.zsz.service.IdNameService;
import com.zsz.service.RegionService;
import com.zsz.tools.AjaxResult;
import com.zsz.tools.CommonUtils;
import com.zsz.tools.Functions;

@WebServlet("/House")
public class HouseServlet extends BaseServlet {
	public void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		HouseService service = new HouseService();
		HouseDTO house = service.getById(id);
		req.setAttribute("house", house);;
		
		HousePicDTO[] pics = service.getPics(id);
		req.setAttribute("pics", pics);
		
		AttachmentService attService = new AttachmentService();
		AttachmentDTO[] attachs = attService.getAttachments(id);
		req.setAttribute("attachs", attachs);
		
		req.getRequestDispatcher("/WEB-INF/house/View.jsp").forward(req, resp);
	}
	
	
	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long cityId = FrontUtils.getCurrentCityId(req);

		String strRegionId = req.getParameter("regionId");
		String strMonthRent = req.getParameter("monthRent");
		String strOrderBy = req.getParameter("orderBy");
		String strTypeId = req.getParameter("typeId");
		String keywords = req.getParameter("keywords");

		Integer startMonthRent = null;// 起始租金
		Integer endMonthRent = null;// 结束租金

		if (!StringUtils.isEmpty(strMonthRent)) {
			String[] monthRents = strMonthRent.split("-");// 100-200,200-*,*-200
			if (!monthRents[0].equals("*"))// 如果为*就是不 设限
			{
				startMonthRent = Integer.parseInt(monthRents[0]);
			}

			if (!monthRents[1].equals("*"))// 如果为*就是不 设限
			{
				endMonthRent = Integer.parseInt(monthRents[1]);
			}
		}
		Long regionId = null;
		if (!StringUtils.isEmpty(strRegionId)) {
			regionId = Long.parseLong(strRegionId);
		}

		Long typeId = null;
		if (!StringUtils.isEmpty(strTypeId)) {
			typeId = Long.parseLong(strTypeId);
		}

		StringBuilder sbSearchDisplay = new StringBuilder();// 显示到界面上的搜索条件
		sbSearchDisplay.append(new CityService().getById(cityId).getName()).append(",");
		if (regionId != null) {
			sbSearchDisplay.append(new RegionService().getById(regionId).getName()).append(",");
		}
		if (startMonthRent != null) {
			sbSearchDisplay.append("房租高于").append(startMonthRent).append(",");
		}
		if (endMonthRent != null) {
			sbSearchDisplay.append("房租低于").append(endMonthRent).append(",");
		}
		if (typeId != null) {
			sbSearchDisplay.append(new IdNameService().getById(typeId).getName()).append(",");
		}
		if (!StringUtils.isEmpty(keywords)) {
			sbSearchDisplay.append(keywords).append(",");
		}
		req.setAttribute("searchDisplay", sbSearchDisplay.toString());

		Long pageIndex = 1L;
		String strPageIndex = req.getParameter("pageIndex");
		if (!StringUtils.isEmpty(strPageIndex)) {
			pageIndex = Long.parseLong(strPageIndex);
		}
		
		HouseSearchOptions searchOpts = new HouseSearchOptions();
		searchOpts.setCityId(cityId);
		searchOpts.setCurrentIndex(pageIndex);
		searchOpts.setEndMonthRent(endMonthRent);
		searchOpts.setKeywords(keywords);
		searchOpts.setOrderByType("monthRent".equals(strOrderBy) ? OrderByType.MonthRent : OrderByType.Area);
		searchOpts.setPageSize(10);
		searchOpts.setRegionId(regionId);
		searchOpts.setStartMonthRent(startMonthRent);
		searchOpts.setTypeId(typeId);

		HouseService houseService = new HouseService();
		HouseSearchResult searchResult = houseService.search2(searchOpts);
		req.setAttribute("houses", searchResult.getResult());

		RegionService regionService = new RegionService();
		RegionDTO[] regions = regionService.getAll(cityId);
		req.setAttribute("regions", regions);

		req.setAttribute("queryString", req.getQueryString());
		req.setAttribute("totalCount", searchResult.getTotalCount());

		
		req.setAttribute("pageIndex", pageIndex);

		// 为z:pager准备urlFormat
		String pagerUrlFormat = Functions.addQueryStringPart(req.getQueryString(), "pageIndex", "{pageNum}");
		req.setAttribute("pagerUrlFormat", req.getContextPath() + "/House?" + pagerUrlFormat);

		req.getRequestDispatcher("/WEB-INF/house/Search.jsp").forward(req, resp);
	}
	
	//预约
	public void makeAppointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phoneNum = req.getParameter("phoneNum");
		String visitDate = req.getParameter("visitDate");
		long houseId  = Long.parseLong(req.getParameter("houseId"));
		Long userId = FrontUtils.getCurrentUserId(req);
		
		HouseAppointmentService service = new HouseAppointmentService();
		service.addnew(userId, name, phoneNum, houseId, CommonUtils.parseDate(visitDate));
		writeJson(resp, new AjaxResult("ok"));
		
		
		
	}
		
}
