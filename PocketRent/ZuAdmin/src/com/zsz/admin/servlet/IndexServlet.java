package com.zsz.admin.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.realm.UserDatabaseRealm;
import org.apache.commons.lang3.StringUtils;

import com.zsz.admin.utils.AdminUtils;
import com.zsz.dto.AdminUserDTO;
import com.zsz.service.AdminUserService;
import com.zsz.tools.AjaxResult;
import com.zsz.tools.VerifyCodeUtils;

@WebServlet("/Index")
public class IndexServlet extends BaseServlet {
/*	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if(StringUtils.isEmpty(action) || action.equals("index"))
		{
			index(req, resp);
		}
		
		else if(action.equals("login"))
		{
			login(req, resp);
		}
		else if(action.equals("loginSubmit"))
		{
			loginSubmit(req, resp);
		}
		
	}*/
	public void logout(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		req.getSession().invalidate();//销毁session
		resp.sendRedirect(req.getContextPath()+"/Index?action=login");
	}
	
	public void index(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		Long userId = AdminUtils.getAdminUserId(req);
		/*Long cityId = AdminUtils.getAdminUserCityId(req); 
		if(userId == null)
		{
			AdminUtils.showError(req, resp, "未登录");
			return; //!!!一定要返回，不能往下走了！
		}*/
		AdminUserDTO adminUser = new AdminUserService().getById(userId);
		req.setAttribute("adminUser", adminUser);
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
	@AllowAnonymous
	public void login(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}
	@AllowAnonymous
	public void loginSubmit(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		//服务器端的校验必不可少
		String phoneNum = req.getParameter("phoneNum");
		String password = req.getParameter("password");
		String verifyCode = req.getParameter("verifyCode");
		if(StringUtils.isEmpty(phoneNum))
		{
			writeJson(resp, new AjaxResult("error","手机号必填"));
			return;
		}
		if(StringUtils.isEmpty(password))
		{
			writeJson(resp, new AjaxResult("error","密码必填"));
			return;
		}
		if(StringUtils.isEmpty(verifyCode))
		{
			writeJson(resp, new AjaxResult("error","验证码必填"));
			return;
		}
		
		String codeInSession = (String)req.getSession().getAttribute("verifyCode"); //从Session中读取正确的验证码
		if(!verifyCode.equalsIgnoreCase(codeInSession)) //忽略大小写
		{
			writeJson(resp, new AjaxResult("error","验证码错误"));
			return;
		}
		AdminUserService adminUserService = new AdminUserService();
		if(adminUserService.checkLogin(phoneNum, password))
		{
			
			//保存当前登录管理员的id和CityId
			//Session中尽量不要放除基本类型之外的其他类型的对象
			AdminUserDTO user = adminUserService.getByPhoneNum(phoneNum);
			AdminUtils.setAdminUserId(req, user.getId());
			AdminUtils.setAdminUserCityId(req, user.getCityId());
			//req.getSession().setAttribute("AdminUserId", user.getId());
			//req.getSession().setAttribute("AdminUserCityId", user.getCityId());
			
			writeJson(resp, new AjaxResult("ok"));
		}
		else
		{
			writeJson(resp, new AjaxResult("error","用户名或者密码错误"));
		}
	}
	@AllowAnonymous
	public void verifyCode(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		String code = VerifyCodeUtils.generateVerifyCode(4);
		req.getSession().setAttribute("verifyCode", code);
		resp.setContentType("image/jpeg");
		VerifyCodeUtils.outputImage(100, 50, resp.getOutputStream(), code);
		
	}

}
