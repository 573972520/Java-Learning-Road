package com.rupeng.test1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Img1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/*
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		//getRealPath中"/"指的是相对于项目WebRoot的"根目录"
		String path = getServletContext().getRealPath("/images/mv.jpg");
		//getRealPath的路径是部署（拷贝）到Tomcat项目文件夹下的路径，不是源代码下的路径
		
		//拿到文件在磁盘上的全路径
		resp.getWriter().println(path);
		
		FileOutputStream fos = new FileOutputStream(getServletContext().getRealPath("/images/1.txt"));
		fos.write(234);
		fos.close();
		*/
		
		resp.setContentType("image/jpeg");//!!!!
		
		String jpgPath = getServletContext().getRealPath("images/mv.jpg");
		String name = RuPengUtils.getParameter(req, "name");
		
		BufferedImage img = ImageIO.read(new File(jpgPath));
		Graphics2D g = img.createGraphics();
		g.setFont(new Font("宋体",Font.BOLD,30));
		g.setColor(Color.red);
		g.drawString(name, 169, 234);
		g.dispose();
		ImageIO.write(img, "JPEG", resp.getOutputStream());
		
		
	}
}
