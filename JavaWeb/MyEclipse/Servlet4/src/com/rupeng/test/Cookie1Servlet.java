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
			resp.addCookie(cookie2); //��������Cookie���ݷ��ظ������
			*/
			Cookie cookie1 = new Cookie("n1", "1");
			cookie1.setMaxAge(10);//��Ϊ��λ��
			resp.addCookie(cookie1);
			
			Cookie cookie2 = new Cookie("n2", "666");
			cookie2.setMaxAge(60);//��Ϊ��λ��MaxAge��֮��������ͽ�����Cookieɾ���������ɾ�ģ�
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
	
	//1��Cookie�����������ά���ģ���ĳ����վ��ص�һ�����ݴ洢����
	//2�����������������������ʱ�򣬾ͻ�������վ��cookie���ݴ洢��������ݷ��͸�������
	//����ͷ�ǣ�Cookie:JSESSIONID=30CA8E60152D112C0B6ED1E2AF48AE17; username=admin; age=5
	//3��Http����������ͨ��set-Cookie����ͷ���߷�����"�ٸ���һ�����ݣ���������"��������ͻ�����������ҴӴ�֮����������������Ҫ�����Ƕ�����
	//4���������˶�ȡ��
	/*for(Cookie cookie :req.getCookies())
	{
		resp.getWriter().println("name="+cookie.getName()+","
								+"value="+cookie.getValue()+"<br/>");
	}*/
	//5����������д�루����Set-Cookie����ͷ��
	/*Cookie cookie1 = new Cookie("username", "admin");
	Cookie cookie2 = new Cookie("age", "5");
	resp.addCookie(cookie1);
	resp.addCookie(cookie2); //��������Cookie���ݷ��ظ������
	 */
	//�����������ɶ��ʱ�򶼻����Cookie������������վ�����ʱ���򲻻ᡣset-Cookie�ǵ��ӵ�
	//Cookie��setMaxAge����Ϊ��λ���Ǵ�set-Cookie��ʼMaxAge��֮��������Ϳ��Խ�����Cookieɾ���������ɾ�ģ�
	//������趨setMaxAge,��ôCookie����������ص�֮������ģ���������ƶ�������֮����ɾ��������������ǲ��ǻ������У����������Cookie���浽������´��������ܿ�������ô����Ҫʹ��setMaxAge��
}
