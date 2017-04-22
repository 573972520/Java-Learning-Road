package com.rupeng.test.oo1;

public class 人类 extends 哺乳动物
{

	private int age;
	public 人类() //先调用父类的构造函数，在调用子类的构造函数
	{
		System.out.println("人类的构造函数");
	}
	public void 直立行走()
	{
		this.age = 8;
		this.setAge(5);
		System.out.println(this.age);
		System.out.println("两条腿");
	}
	public void 玩手机()
	{
		System.out.println("玩手机");
	}
}
