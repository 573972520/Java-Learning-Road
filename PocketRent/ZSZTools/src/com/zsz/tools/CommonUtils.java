package com.zsz.tools;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
}
