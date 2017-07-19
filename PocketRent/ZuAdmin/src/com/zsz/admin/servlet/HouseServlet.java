package com.zsz.admin.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsz.admin.utils.AdminUtils;
import com.zsz.dao.utils.IdNameDAO;
import com.zsz.dto.AttachmentDTO;
import com.zsz.dto.CommunityDTO;
import com.zsz.dto.HouseDTO;
import com.zsz.dto.IdNameDTO;
import com.zsz.dto.RegionDTO;
import com.zsz.service.AttachmentService;
import com.zsz.service.CommunityService;
import com.zsz.service.HouseService;
import com.zsz.service.IdNameService;
import com.zsz.service.RegionService;
import com.zsz.tools.AjaxResult;

@WebServlet("/House")
public class HouseServlet extends BaseServlet
{
	public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long adminUserCityId = AdminUtils.getAdminUserCityId(req);//获取用户所在的城市
		if(adminUserCityId == null){
			
			AdminUtils.showError(req, resp, "总部的人不能管理房源");
			return;
		}
		
		long typeId = Long.parseLong(req.getParameter("typeId"));
		long pageIndex = Long.parseLong(req.getParameter("pageIndex"));
		req.setAttribute("typeId", typeId);// 给forward中的jsp页面中的pager等地方用的
		req.setAttribute("pageIndex", pageIndex);
		
		
		HouseService houseService = new HouseService();
		long totalCount = houseService.getTotalCount(adminUserCityId, typeId);//获取指定城市、指定类别下的数据总条数
		req.setAttribute("totalCount", totalCount);// 供<z:pager使用
		
		HouseDTO[] houses = houseService.getPagedData(adminUserCityId, typeId, 10, pageIndex);// 查询页数据
		req.setAttribute("houses", houses);
		
		req.setAttribute("ctxPath", req.getContextPath());// 给<z:pager的urlFormat用
		req.getRequestDispatcher("/WEB-INF/house/houseList.jsp").forward(req, resp);
		 
	}
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		HouseService service = new HouseService();
		service.markDeleted(id);
		writeJson(resp, new AjaxResult("ok"));
	}
		
	
	public void loadCommunities(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long regionId = Long.parseLong(req.getParameter("regionId"));
		CommunityDTO[] communities = new CommunityService().getByRegionId(regionId);
		writeJson(resp, new AjaxResult("ok","",communities));
	}
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long typeId = Long.parseLong(req.getParameter("typeId"));
		Long cityId = AdminUtils.getAdminUserCityId(req);
		if(cityId == null)
		{
			AdminUtils.showError(req, resp, "总部的人不能管理房源");
			return;
		}
		RegionService regionService = new RegionService();
		RegionDTO[] regions = regionService.getAll(cityId); //取得城市中的区域
		
		IdNameService idNameService = new IdNameService();
		IdNameDTO[] roomTypes = idNameService.getAll("户型");
		IdNameDTO[] statuses = idNameService.getAll("房屋状态");
		IdNameDTO[] decorateStatus = idNameService.getAll("装修状态");
		
		AttachmentDTO[] attachments = new AttachmentService().getAll();
		
		req.setAttribute("typeId", typeId);
		req.setAttribute("regions", regions);
		req.setAttribute("roomTypes", roomTypes);
		req.setAttribute("statuses", statuses);
		req.setAttribute("decorateStatus", decorateStatus);
		req.setAttribute("attachments", attachments);
		
		
		req.getRequestDispatcher("/WEB-INF/house/houseAdd.jsp").forward(req, resp);
		
	}
	public void addSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long typeId = Long.parseLong(req.getParameter("typeId"));
		
	}
	
		
}
