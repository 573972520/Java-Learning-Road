package 反射;

import java.lang.reflect.Field;

public class ReflectTest4
{

	public static void main(String[] args) throws NoSuchFieldException, SecurityException
	{
		// TODO Auto-generated method stub
		Class clz = Chinese.class;
		Field fa = clz.getField("Count");//获得的是public字段
		System.out.println(fa);
		/*
		//Field fa1 = clz.getField("aa");//NoSuchFieldException没有这么一个字段（因为aa是private）
		//System.out.println(fa1);
		*/
		System.out.println("变量的名字" + fa.getName());
		System.out.println("变量的类型" + fa.getGenericType());

		for (Field f : clz.getFields())
		{
			System.out.println("变量名" + f.getName() + ",类型为" + f.getGenericType());
		}
	}

}
