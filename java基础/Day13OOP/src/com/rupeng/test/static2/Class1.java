package com.rupeng.test.static2;

public class Class1
{
	public static int AA = 5;
	//静态代码块只执行一次
	//在类第一次被使用的时候执行，并且只执行一次
	static
	{
		System.out.println("Class1的静态代码块1");
	}
	public static void hello()
	{
		System.out.println("hello");
	}
	public  Class1()
	{
		System.out.println("Class1的构造函数");
	}
	static
	{
		System.out.println("Class1的静态代码块2");
	}
}
