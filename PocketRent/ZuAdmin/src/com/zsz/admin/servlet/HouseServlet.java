package com.zsz.admin.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.zsz.admin.utils.AdminUtils;
import com.zsz.dao.utils.IdNameDAO;
import com.zsz.dto.AttachmentDTO;
import com.zsz.dto.CommunityDTO;
import com.zsz.dto.HouseDTO;
import com.zsz.dto.HousePicDTO;
import com.zsz.dto.IdNameDTO;
import com.zsz.dto.RegionDTO;
import com.zsz.service.AttachmentService;
import com.zsz.service.CommunityService;
import com.zsz.service.HouseService;
import com.zsz.service.IdNameService;
import com.zsz.service.RegionService;
import com.zsz.tools.AjaxResult;
import com.zsz.tools.CommonUtils;

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
		req.setAttribute("typeId", typeId);
		if(cityId == null)
		{
			AdminUtils.showError(req, resp, "总部的人不能管理房源");
			return;
		}
		fillEditAddRequest(req, cityId);
		
		req.getRequestDispatcher("/WEB-INF/house/houseAdd.jsp").forward(req, resp);
		
	}
	public void addSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long cityId = AdminUtils.getAdminUserCityId(req);
		
		long typeId = Long.parseLong(req.getParameter("typeId"));
		long regionId = Long.parseLong(req.getParameter("regionId"));
		long communityId = Long.parseLong(req.getParameter("communityId"));
		long roomTypeId = Long.parseLong(req.getParameter("roomTypeId"));
		String address = req.getParameter("address");
		int monthRent = Integer.parseInt(req.getParameter("monthRent"));
		long statusId = Long.parseLong(req.getParameter("statusId"));
		double area = Double.parseDouble(req.getParameter("area"));
		long decorateStatusId = Long.parseLong(req.getParameter("decorateStatusId"));
		int floorIndex = Integer.parseInt(req.getParameter("floorIndex"));
		int totalFloorCount = Integer.parseInt(req.getParameter("totalFloorCount"));
		String direction = req.getParameter("direction");
		Date lookableDateTime = CommonUtils.parseDate(req.getParameter("lookableDateTime"));
		Date checkInDateTime = CommonUtils.parseDate(req.getParameter("checkInDateTime"));
		String ownerName = req.getParameter("ownerName");
		String ownerPhoneNum = req.getParameter("ownerPhoneNum");
		String description = req.getParameter("description");
		String[] attachmentIds = req.getParameterValues("attachmentId");

		HouseDTO house = new HouseDTO();
		house.setAddress(address);
		house.setArea(area);
		house.setAttachmentIds(CommonUtils.toLongArray(attachmentIds));
		house.setCheckInDateTime(checkInDateTime);
		house.setCommunityId(communityId);
		house.setCityId(cityId);
		house.setDecorateStatusId(decorateStatusId);
		house.setDescription(description);
		house.setDirection(direction);
		house.setFloorIndex(floorIndex);
		house.setLookableDateTime(lookableDateTime);
		house.setMonthRent(monthRent);
		house.setOwnerName(ownerName);
		house.setOwnerPhoneNum(ownerPhoneNum);
		house.setRegionId(regionId);
		house.setRoomTypeId(roomTypeId);
		house.setStatusId(statusId);
		house.setTotalFloorCount(totalFloorCount);
		house.setTypeId(typeId);
		
		new HouseService().addnew(house);
		writeJson(resp, new AjaxResult("ok"));
	}

	
	public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long cityId = AdminUtils.getAdminUserCityId(req);
		if(cityId == null)
		{
			AdminUtils.showError(req, resp, "总部的人不能管理房源");
			return;
		}
		
		long id = Long.parseLong(req.getParameter("id"));
		HouseDTO dto = new HouseService().getById(id);
		if(dto == null)
		{
			AdminUtils.showError(req, resp, "找不到这个房源");
			return;
		}
		req.setAttribute("house", dto);
		
		AttachmentDTO[] houseAttachments = new AttachmentService().getAttachments(id);//获取房子的配套设施
		long[] houseAttachmentIds =  new long[houseAttachments.length];
		for (int i = 0; i < houseAttachments.length; i++) {
			houseAttachmentIds[i] = houseAttachments[i].getId();
		}
		req.setAttribute("houseAttachmentIds", houseAttachmentIds);
		
		fillEditAddRequest(req, cityId);
		
		req.getRequestDispatcher("/WEB-INF/house/houseEdit.jsp").forward(req, resp);
		
		
	}
	private void fillEditAddRequest(HttpServletRequest req, Long cityId) {
		RegionService regionService = new RegionService();
		RegionDTO[] regions = regionService.getAll(cityId); //取得城市中的区域
		
		IdNameService idNameService = new IdNameService();
		IdNameDTO[] roomTypes = idNameService.getAll("户型");
		IdNameDTO[] statuses = idNameService.getAll("房屋状态");
		IdNameDTO[] decorateStatus = idNameService.getAll("装修状态");
		
		AttachmentDTO[] attachments = new AttachmentService().getAll();
		
		req.setAttribute("regions", regions);
		req.setAttribute("roomTypes", roomTypes);
		req.setAttribute("statuses", statuses);
		req.setAttribute("decorateStatus", decorateStatus);
		req.setAttribute("attachments", attachments);
		
		Date now = new Date();
		req.setAttribute("now",DateFormatUtils.format(now, "yyyy-MM-dd"));
	}
	
	public void editSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		long typeId = Long.parseLong(req.getParameter("typeId"));
		long regionId = Long.parseLong(req.getParameter("regionId"));
		long communityId = Long.parseLong(req.getParameter("communityId"));
		long roomTypeId = Long.parseLong(req.getParameter("roomTypeId"));
		String address = req.getParameter("address");
		int monthRent = Integer.parseInt(req.getParameter("monthRent"));
		long statusId = Long.parseLong(req.getParameter("statusId"));
		double area = Double.parseDouble(req.getParameter("area"));
		long decorateStatusId = Long.parseLong(req.getParameter("decorateStatusId"));
		int floorIndex = Integer.parseInt(req.getParameter("floorIndex"));
		int totalFloorCount = Integer.parseInt(req.getParameter("totalFloorCount"));
		String direction = req.getParameter("direction");
		Date lookableDateTime = CommonUtils.parseDate(req.getParameter("lookableDateTime"));
		Date checkInDateTime = CommonUtils.parseDate(req.getParameter("checkInDateTime"));
		String ownerName = req.getParameter("ownerName");
		String ownerPhoneNum = req.getParameter("ownerPhoneNum");
		String description = req.getParameter("description");
		String[] attachmentIds = req.getParameterValues("attachmentId");

		HouseDTO house = new HouseDTO();
		house.setId(id);;
		house.setAddress(address);
		house.setArea(area);
		house.setAttachmentIds(CommonUtils.toLongArray(attachmentIds));
		house.setCheckInDateTime(checkInDateTime);
		house.setCommunityId(communityId);
		house.setDecorateStatusId(decorateStatusId);
		house.setDescription(description);
		house.setDirection(direction);
		house.setFloorIndex(floorIndex);
		house.setLookableDateTime(lookableDateTime);
		house.setMonthRent(monthRent);
		house.setOwnerName(ownerName);
		house.setOwnerPhoneNum(ownerPhoneNum);
		house.setRegionId(regionId);
		house.setRoomTypeId(roomTypeId);
		house.setStatusId(statusId);
		house.setTotalFloorCount(totalFloorCount);
		house.setTypeId(typeId);
		
		new HouseService().update(house);
		writeJson(resp, new AjaxResult("ok"));
	}
			
	public void picsList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		HousePicDTO[] pics = new HouseService().getPics(id);// 获取房子的配图
		req.setAttribute("pics", pics);
		req.setAttribute("id", id);
		req.getRequestDispatcher("/WEB-INF/house/picsList.jsp").forward(req, resp);
	}
}
