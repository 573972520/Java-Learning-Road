package com.rupeng.test.oo1;

public class animal
{
	//如果没有指定父类，则默认继承自Object
	//父类，子类
	//间接父类(基类)，间接子类
	private int age;
	
	public animal()
	{
		System.out.println("动物的构造函数");
	}
	
	//一个类默认有一个无参的构造函数
	//但是一旦声明一个构造函数，那么默认的无参构造函数就没有了
	public animal(int i)
	{
		System.out.println("动物的构造函数2,i="+i);
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	public void 繁殖()
	{
		System.out.println("生小孩");
	}
	public void 排泄()
	{
		System.out.println("普查");
	}
	public void 进食()
	{
		System.out.println("吃吃吃");
		System.out.println("age="+this.age);
	}
}
