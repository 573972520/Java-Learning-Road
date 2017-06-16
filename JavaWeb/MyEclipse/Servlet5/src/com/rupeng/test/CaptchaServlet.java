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

public class CaptchaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("image/jpeg");
		BufferedImage img = new BufferedImage(100, 30, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = img.createGraphics();
		g.setColor(Color.red);
		g.setFont(new Font("宋体",Font.BOLD,30));
		String randNum = createRandNum();
		
		req.getSession().setAttribute("YZM", randNum);//把生成的验证码放到session中
		//不能放到Cookie等浏览器端可以接触的地方，必须放到服务器中
		g.drawString(randNum, 10, 25);
		g.dispose();
		ImageIO.write(img, "JPEG", resp.getOutputStream());
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
