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
	
	//���Servlet�����ܽ���Post�����ֽ���Get���󣬲���Get��Post�Ĵ���һ��
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//resp.sendRedirect("http://www.rupeng.com"); //sendRedirect֮��Ĵ�����Ȼ��ִ��
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
		PrintWriter out = resp.getWriter();//����Ҳ�Ƕ�resp.getOutputStream��һ����װ
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
		//req.getHeader��ȡ������ͷ��ֵ
		resp.getWriter().println("UserAgent="+req.getHeader("User-Agent")+"<br/>");
		//
		resp.getWriter().println("Connection="+req.getHeader("Connection")+"<br/>");
		*/
		/*		��������
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
		this.doGet(req,resp); //��ʹ��Post�����ʱ���һص�Get������
	}
	
	
	
	/*
	 * Get��Post������
	 * Get���������Ƿŵ�HttpЭ������ĵ�һ�У���������
	 * Post�����Ƿŵ�HttpЭ�鱨�����У����Ȳ���
	 * ��������������ݣ���Get,�������������ݣ������¡��ļ�������Post
	 * Get:��������ܻỺ��
	 * Post:һ�������л��棨��Զ�����������Ҫ���µ����ݣ�
	 * */
}
