package com.rupeng.test;

import java.net.HttpCookie;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySession {
	
	//��MySessionΪkey,Session��ֵ��Ϊvalue�ļ�ֵ��
	private static HashMap<String, HashMap<String,String>> map = new HashMap<String, HashMap<String,String>>();
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private String mSessionId = null;
	public MySession(HttpServletRequest req,HttpServletResponse resp)
	{
		this.req = req;
		this.resp = resp;
		
		//��������������cookie�в�ѯ�Ƿ�������ΪMSessionId��Cookie
		Cookie[] cookies = req.getCookies();
		if(cookies != null)
		{
			for(Cookie cookie : cookies)
			{
				if(cookie.getName().equals("MSessionId"))
				{
					mSessionId = cookie.getValue();
				}
			
			}
		}
		
		//���û����˵��û�д�����Ӧ��Session
		if(mSessionId == null)
		{
			mSessionId = UUID.randomUUID().toString();//����һ��Ψһ���ַ���
			
			//���Ǵ��Session������ݵ�Map
			HashMap<String,String> dataMap = new HashMap<String,String>();
			map.put(mSessionId, dataMap);
			//ͨ��Response���������MSessionId�浽Cookie��
			Cookie cookie = new Cookie("MSessionId", mSessionId);
			resp.addCookie(cookie);
		}
		
	}
	
	public void setAttribute(String name,String value)
	{
		HashMap<String,String> dataMap = map.get(mSessionId);
		dataMap.put(name, value);
	}
	
	public String getAttribute(String name)
	{
		HashMap<String,String> dataMap = map.get(mSessionId);
		return dataMap.get(name);
	}
	
}
