package com.zsz.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsz.dto.AttachmentDTO;
import com.zsz.dto.HouseDTO;
import com.zsz.dto.HousePicDTO;
import com.zsz.service.AttachmentService;
import com.zsz.service.HouseService;

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
		
}
