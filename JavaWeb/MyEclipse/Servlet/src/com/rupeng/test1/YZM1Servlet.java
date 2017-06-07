package com.rupeng.test1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class YZM1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("image/jpeg");
		String yzm = createYZM();
		BufferedImage img = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = img.createGraphics();
		g.setFont(new Font("宋体",Font.BOLD,30));
		g.setColor(Color.red);
		g.drawString(yzm, 20, 20);
		g.dispose();
		ImageIO.write(img, "JPEG", resp.getOutputStream());
	}
	static String createYZM()
	{
		char[] chars = new char[]{'a','b','c','d','e','f','h','k','l','m','4','7'};
		String yzm = "";
		Random rand = new Random();
		for(int i = 0;i<4;i++) 
		{
			int index = rand.nextInt(chars.length);//生成一个chars中的随机位置
			char ch = chars[index];//取出这个随机位置的字符作为验证码的一部分
			yzm = yzm + ch;
		}
		return yzm;
	}
}
