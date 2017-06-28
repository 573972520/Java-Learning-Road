package com.zsz.tools;

public class Functions {
	/**
	 * 判断values是否存在于values这个数组或者集合中
	 * @param values
	 * @param value
	 * @return
	 */
	public static boolean contains(Object values,Object value)
	{
		
		if(values == null || value == null)
		{
			return false;
		}
		Iterable iterable;
		if(values.getClass().isArray())
		{
			iterable = CommonUtils.toList(values); //将数组转换为一个List对象
		}
		else if(values instanceof Iterable) //实现了Iterable都可以使用增强for循环来遍历
				//List、Queue、Set等都实现了这个Iterable接口
				//但是数组没有实现这个接口
		{
			iterable = (Iterable)values;
		}
		else
		{
			throw new IllegalArgumentException("第一个参数要传递数组或者实现了Iterable的对象");
		}
		for(Object item : iterable)
		{
			if(value.equals(item)) //不要用==，因为==比较的是对象
			{
				return true; //找到了。存在
			}
		}
		return false; //没有
	}
}
