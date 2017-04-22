package com.rupeng.test.static1;

public class StaticTest1
{
	private static long i = getIt(); //static成员变量（字段）只在第一次使用的时候初始化，而不是每次取它的值都会去初始化
	private static long a = 0;
	public static void main(String[] args)
	{
		System.out.println(StaticTest1.i);
		System.out.println(StaticTest1.i);
		System.out.println(StaticTest1.i);
	}
	static long getIt()
	{
		System.out.println("执行getIt了"); //只执行一次输出
		a++;
		return a;
//		return System.currentTimeMillis();
	}
}
