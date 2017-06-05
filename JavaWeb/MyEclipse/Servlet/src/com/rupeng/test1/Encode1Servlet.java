package com.rupeng.test1;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Encode1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String txt1 = req.getParameter("txt1"); //服务器对于浏览器提交的编码后的value，服务器会解码
		resp.getWriter().print(txt1);
		
		//String h = "abc";
		String h = URLEncoder.encode("a&b=4", "UTF-8");
		String html = "<a href='http://www.rupeng.com/a?un="+h+"'>aaa</a>";
		resp.getWriter().print(html);
		
		String h1 = URLDecoder.decode("a&b=4", "UTF-8");
		resp.getWriter().print(h1);
		
				
	}
}
