package com.rupeng.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookie1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String action = req.getParameter("action");
		if(action.equals("write"))
		{
			/*Cookie cookie1 = new Cookie("username", "admin");
			Cookie cookie2 = new Cookie("age", "5");
			resp.addCookie(cookie1);
			resp.addCookie(cookie2); //把新增的Cookie数据返回给浏览器
			*/
			Cookie cookie1 = new Cookie("n1", "1");
			cookie1.setMaxAge(10);//秒为单位，
			resp.addCookie(cookie1);
			
			Cookie cookie2 = new Cookie("n2", "666");
			cookie2.setMaxAge(60);//秒为单位，MaxAge秒之后，浏览器就将这条Cookie删掉（浏览器删的）
			resp.addCookie(cookie2);
		}
		else if(action.equals("read"))
		{
			Cookie[] cookies = req.getCookies();
			if(cookies != null)
			{
				for(Cookie cookie :req.getCookies())
				{
					resp.getWriter().println("name="+cookie.getName()+","
											+"value="+cookie.getValue()+"<br/>");
				}
			}
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
	//1、Cookie是浏览器负责维护的，和某个网站相关的一块数据存储区域
	//2、浏览器向服务器发出请求的时候，就会把这个网站的cookie数据存储区域的数据发送给服务器
	//报文头是：Cookie:JSESSIONID=30CA8E60152D112C0B6ED1E2AF48AE17; username=admin; age=5
	//3、Http服务器可以通过set-Cookie报文头告诉服务器"再给你一点数据，存起来吧"，浏览器就会存起来，并且从此之后再向服务器请求就要把他们都带着
	//4、服务器端读取：
	/*for(Cookie cookie :req.getCookies())
	{
		resp.getWriter().println("name="+cookie.getName()+","
								+"value="+cookie.getValue()+"<br/>");
	}*/
	//5、服务器端写入（生成Set-Cookie报文头）
	/*Cookie cookie1 = new Cookie("username", "admin");
	Cookie cookie2 = new Cookie("age", "5");
	resp.addCookie(cookie1);
	resp.addCookie(cookie2); //把新增的Cookie数据返回给浏览器
	 */
	//向服务器申请啥的时候都会带着Cookie，向其他的网站请求的时候则不会。set-Cookie是叠加的
	//Cookie的setMaxAge以秒为单位，是从set-Cookie开始MaxAge秒之后，浏览器就可以将这条Cookie删掉（浏览器删的）
	//如果不设定setMaxAge,那么Cookie是在浏览器关掉之后清除的，否则就是制定的秒数之后再删除（无论浏览器是不是还在运行），如果想让Cookie保存到浏览器下次重启还能看到，那么就需要使用setMaxAge了
}
