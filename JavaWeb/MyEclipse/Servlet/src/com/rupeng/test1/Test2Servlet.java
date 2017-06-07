package com.rupeng.test1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test2Servlet extends HttpServlet {
	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		resp.setContentType("text/html");
		resp.getWriter().println("GET:"+name);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		resp.setContentType("text/html");
		resp.getWriter().println("POST:"+name);
	}
	*/
	
	//如果Servlet即可能接收Post请求，又接收Get请求，并且Get和Post的处理一致
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//resp.sendRedirect("http://www.rupeng.com"); //sendRedirect之后的代码仍然会执行
		resp.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		resp.setContentType("text/html");
		
		/*
		OutputStreamWriter osw = new OutputStreamWriter(resp.getOutputStream());
		BufferedWriter buffWriter = new BufferedWriter(osw);
		buffWriter.write("hello");
		buffWriter.close();
		osw.close();
		*/
		PrintWriter out = resp.getWriter();//最终也是对resp.getOutputStream的一个封装
		out.println("ye hello");
		
		/*resp.getWriter().println("name:"+name);
		String qs = req.getQueryString();
		resp.getWriter().println("QueryString="+qs+"<br/>");
		
		String contextPath = req.getContextPath();
		resp.getWriter().println("ContextPath="+contextPath+"<br/>");
		
		String remoteAddr = req.getRemoteAddr();
		resp.getWriter().println("RemoteAddr="+remoteAddr+"<br/>");
		
		String requestUri = req.getRequestURI();
		resp.getWriter().println("RequestUri="+requestUri+"<br/>");
		
		resp.getWriter().println("getLocale="+req.getLocale()+"<br/>");
		//req.getHeader获取请求报文头的值
		resp.getWriter().println("UserAgent="+req.getHeader("User-Agent")+"<br/>");
		//
		resp.getWriter().println("Connection="+req.getHeader("Connection")+"<br/>");
		*/
		/*		输出结果：
		 * 		name:null QueryString=null
				ContextPath=/Servlet
				RemoteAddr=192.168.248.1
				RequestUri=/Servlet/aa/test2
				getLocale=zh_TW
				UserAgent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.86 Safari/537.36
				Connection=keep-alive
		*/
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req,resp); //到使用Post请求的时候，找回到Get请求中
	}
	
	
	
	/*
	 * Get和Post的区别
	 * Get参数数据是放到Http协议请求的第一行，长度有限
	 * Post参数是放到Http协议报文体中，长度不限
	 * 如果传输少量数据，用Get,如果传输大量数据（如文章、文件）则用Post
	 * Get:浏览器可能会缓存
	 * Post:一定不会有缓存（永远都会向服务器要最新的数据）
	 * */
}
