package com.rupeng.test;

import java.net.HttpCookie;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySession {
	
	//以MySession为key,Session键值对为value的键值对
	private static HashMap<String, HashMap<String,String>> map = new HashMap<String, HashMap<String,String>>();
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private String mSessionId = null;
	public MySession(HttpServletRequest req,HttpServletResponse resp)
	{
		this.req = req;
		this.resp = resp;
		
		//到请求的浏览器端cookie中查询是否有名字为MSessionId的Cookie
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
		
		//如果没有则说明没有创立对应的Session
		if(mSessionId == null)
		{
			mSessionId = UUID.randomUUID().toString();//创建一个唯一的字符串
			
			//就是存放Session多个数据的Map
			HashMap<String,String> dataMap = new HashMap<String,String>();
			map.put(mSessionId, dataMap);
			//通过Response让浏览器把MSessionId存到Cookie中
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
