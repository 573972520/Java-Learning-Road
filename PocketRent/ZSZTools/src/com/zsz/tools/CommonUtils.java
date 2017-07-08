package com.zsz.tools;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommonUtils {
	public static List<Object> toList(Object arrays)
	{
		if(arrays.getClass().isArray() == false)
		{
			throw new IllegalArgumentException("不是数组对象");
		}
		List<Object> list = new ArrayList<Object>();
		int len = Array.getLength(arrays);
		for(int i = 0;i<len;i++)
		{
			Object item = Array.get(arrays, i);
			list.add(item);
		}
		return list;
	}
	
	public static boolean isNullOrWhiteSpace(String s)
	{
		if(s == null)
		{
			return true;
		}
		return s.trim().length() == 0;  //  ""    "    "
	}
	
	public static boolean isEmail(String email)
	{
		if (isNullOrWhiteSpace(email))
		{
			return false;
		}
		Pattern p = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");// 复杂匹配
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isPhoneNum(String phoneNum)
	{
		if (isNullOrWhiteSpace(phoneNum))
		{
			return false;
		}
		Pattern p = Pattern.compile("^1(\\d{10})$");// 复杂匹配
		Matcher m = p.matcher(phoneNum);
		return m.matches();
	}


	public static Date parseDate(String s)
	{
		try
		{
			return new SimpleDateFormat("yyyy-MM-dd").parse(s);
		} catch (ParseException e)
		{
			throw new IllegalArgumentException("日期格式错误：" + s, e);
		}
	}


	public static String urlEncodeUTF8(String str)
	{
		try
		{
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public static Gson createGson()
	{
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson;
	}
	
}
