package com.zsz.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsz.tools.VerifyCodeUtils;

@WebServlet("/User")
public class UserServlet extends BaseServlet {
	
	public void reg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/Register.jsp").forward(req, resp);
	}
	//注册时候发送短信验证码
	public void reqSendSmsCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	public void regSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	public void loginSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	public void findPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	public void findPasswordSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	//图片验证码
	public void verifyCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpeg");
		String code = VerifyCodeUtils.generateVerifyCode(4);
		req.setAttribute("VerifyCode", code);
		VerifyCodeUtils.outputImage(100, 50, resp.getOutputStream(), code);
	}
}
