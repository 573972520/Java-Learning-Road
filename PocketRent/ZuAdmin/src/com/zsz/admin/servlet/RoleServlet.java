package com.zsz.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsz.dao.utils.PermissionDAO;
import com.zsz.dto.PermissionDTO;
import com.zsz.dto.RoleDTO;
import com.zsz.service.PermissionService;
import com.zsz.service.RoleService;
import com.zsz.tools.AjaxResult;
import com.zsz.tools.CommonUtils;

@WebServlet("/Role")
public class RoleServlet extends BaseServlet {
	public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoleService roleServlet = new RoleService();
		RoleDTO[] roles = roleServlet.getAll();
		req.setAttribute("roles", roles);
		req.getRequestDispatcher("/WEB-INF/role/roleList.jsp").forward(req, resp);		
	}
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		RoleService service = new RoleService();
		service.markDeleted(id);
		this.writeJson(resp, new AjaxResult("ok"));
		
	}
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PermissionDAO permDAO = new PermissionDAO();
		PermissionDTO[] perms =permDAO.getAll();
		req.setAttribute("perms", perms);
		req.getRequestDispatcher("/WEB-INF/role/roleAdd.jsp").forward(req, resp);
	}
	public void addSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rolename = req.getParameter("rolename");
		String[] permIds = req.getParameterValues("permId");
		
		RoleService service = new RoleService();
		long roleId = service.addnew(rolename);
		
		PermissionService permService = new PermissionService();
		permService.addPermIds(roleId, CommonUtils.toLongArray(permIds));
		writeJson(resp, new AjaxResult("ok"));
	}
		
	
}
