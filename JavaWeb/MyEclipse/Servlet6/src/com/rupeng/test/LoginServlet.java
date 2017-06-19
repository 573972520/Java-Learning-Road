package com.rupeng.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if(RuPengUtils.isNullOrEmpty(action))
		{
			req.getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
		else if(action.equals("yzm"))
		{
			resp.setContentType("image/jpeg");
			BufferedImage img = new BufferedImage(100, 30, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D g = img.createGraphics();
			g.setColor(Color.red);
			g.setFont(new Font("宋体",Font.BOLD,30));
			String randNum = createRandNum();
			
			req.getSession().setAttribute("YZM", randNum);
			
			g.drawString(randNum, 0, 25);
			g.dispose();
			
			ImageIO.write(img, "JPEG", resp.getOutputStream());
			
		}
		else if(action.equals("loginSubmit"))
		{
			String username = RuPengUtils.getParameter(req, "username");
			String password = req.getParameter("password");
			String yzm = req.getParameter("yzm");
			
			AjaxResult result = new AjaxResult();
			String yzmInSession = (String)req.getSession().getAttribute("YZM");
			if(!yzm.equals(yzmInSession))
			{
				result.setErrorCode("yzmError"); //验证码错误
			}
			else
			{
				UserInfo user =  UserDAO.getByUserName(username);
				if(user == null)
				{
					result.setErrorCode("userNotFound"); //用户名不存在
				}
				else if(!user.getPassword().equals(password))
				{
					result.setErrorCode("passwordError"); //密码错误
				}
				else
				{
					result.setErrorCode("ok");
				}
			}
			Gson gson = new Gson();
			String json = gson.toJson(result);
			resp.getWriter().print(json);
		}
			
	}
	
	static String createRandNum()
	{
		char[] nums = {'a','c','d','e','f','g','n','z','t','s','x','y','1','3','6','7','8','0'};
		String randNum = "";
		Random rand = new Random(System.currentTimeMillis());
		for(int i = 0;i <= 4;i++)
		{
			randNum += nums[rand.nextInt(nums.length)];
		}
		return randNum;
	}
	
	
}
