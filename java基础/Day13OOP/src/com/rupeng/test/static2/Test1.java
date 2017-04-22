package com.rupeng.test.static2;

public class Test1
{
	public static void main(String[] args)
	{
		System.out.println("main is begin");
		Class1 c0 = null;
		System.out.println("1");
		System.out.println(Class1.AA);
		System.out.println("2");
		Class1.hello();
		Class1 c1 = new Class1();
		Class1 c2 = new Class1();
	}
}
