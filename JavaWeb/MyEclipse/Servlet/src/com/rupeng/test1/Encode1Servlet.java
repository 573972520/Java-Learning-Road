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
		String txt1 = req.getParameter("txt1"); //����������������ύ�ı�����value�������������
		resp.setContentType("text/html;charset=UTF-8"); //��Ҫ�������ȥ��~���������ظ��ҵ���ʲô��ʽ
//		resp.setContentType("text/plain"); //���ظ��������ͨ�ı�����Ҫ����htmlȥ����
		resp.setCharacterEncoding("UTF-8");
		byte[] bytes = txt1.getBytes("ISO-8859-1");
		String utf8Txt1 =  new String(bytes,"UTF-8");//�Ͳ������ˣ�����ISO-8859-1�õ�bytes,Ȼ��ʹ��UTF-8���������ַ���
		
		
		resp.getWriter().print("<html><head><meta charset='utf-8' /></head><body>");
		resp.getWriter().print("<strong>"+utf8Txt1+"</strong>");
		resp.getWriter().print("</body></html>");
		
		
		//String h = "abc";
		/*String h = URLEncoder.encode("a&b=4", "UTF-8");
		String html = "<a href='http://www.rupeng.com/a?un="+h+"'>aaa</a>";
		resp.getWriter().print(html);
		
		String h1 = URLDecoder.decode("a&b=4", "UTF-8");
		resp.getWriter().print(h1);*/
		
				
	}
}
