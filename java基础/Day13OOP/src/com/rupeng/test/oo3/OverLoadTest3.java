package com.rupeng.test.oo3;

public class OverLoadTest3
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		f1((double)1);
		f1(1.0);
		f1(1); //没有f1(int i)这个重载函数，那么它就匹配f1(double d)
		//一旦有了f1(int i)，那么它就匹配更适合我的f1(int i)
		//如果还想让我匹配f1(double d)，那么就显示转换f1((double)1)
		String s = "hello";
		f2(s); //String继承自Object，但是s更加匹配f2(String s)，如果没有f2(String s)那么将会匹配到f2(Object obj)
		f2((Object)s);
	}
	
	static void f1(int i)
	{
		System.out.println("int i="+i);
	}
	
	static void f1(double d)
	{
		System.out.println("int d="+d);
	}
	
	static void f2(Object obj)
	{
		System.out.println("obj");
	}
	
	static void f2(String s)
	{
		System.out.println("string");
	}
	
}
