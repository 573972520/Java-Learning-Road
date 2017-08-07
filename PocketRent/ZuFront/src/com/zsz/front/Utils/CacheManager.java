package com.zsz.front.Utils;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.zsz.tools.CommonUtils;

import redis.clients.jedis.Jedis;

public class CacheManager {
	private static final CacheManager instance = new CacheManager();
	
	public static CacheManager getManager()
	{
		return instance;
	}
	
	/**
	 * 在缓存中保存以name为key，以value（gson处理）为值的键值对，有效期为liveSeconds秒
	 * @param name
	 * @param value
	 * @param liveSeconds
	 */
	public void setValue(String name,Object value,int liveSeconds)
	{
		Gson gson = CommonUtils.createGson();
		String json = gson.toJson(value);
		Jedis jedis = FrontUtils.createJedis();
		try
		{
			jedis.setex(name, liveSeconds, json);
		}
		finally
		{
			jedis.close();
		}
	}
	
	/**
	 * 在缓存中获取name为key的数据， 并且用clz类型进行反序列化
	 * @param name
	 * @param clz
	 * @return 读到的对象，如果没有读取到则返回null
	 */
	public Object getValue(String name,Class clz)
	{
		Gson gson = CommonUtils.createGson();
		Jedis jedis = FrontUtils.createJedis();
		try
		{
			String json = jedis.get(name);
			if(StringUtils.isEmpty(json))
			{
				return null;
			}
			else
			{
				return gson.fromJson(json, clz);
			}
		}
		finally
		{
			jedis.close();
		}
	}
}
