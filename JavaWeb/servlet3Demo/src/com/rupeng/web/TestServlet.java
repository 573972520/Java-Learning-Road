package com.rupeng.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("testServlet被调用了");
		
		Part part = request.getPart("file1");
		String  filename = part.getSubmittedFileName();
		System.out.println("上传的文件的名称为"+filename);
		
		long size = part.getSize();
		System.out.println("上传的文件的大小为"+size);
		
		InputStream input = part.getInputStream();
		
		File file = new File("F:/"+filename);
		FileOutputStream output = new FileOutputStream(file);
		byte[] buff = new byte[1024];
		int len = 0;
		while((len=input.read(buff)) != -1)
		{
			output.write(buff,0,len);
		}
		
		output.close();
		part.delete();
		
		System.out.println("文件上传成功");
		System.out.println("普通表单aa的值为："+request.getParameter("aa"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
