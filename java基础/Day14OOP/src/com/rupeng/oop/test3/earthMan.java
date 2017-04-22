package com.rupeng.oop.test3;

public abstract class earthMan
{
	//空方法也是一种方法
	//目的： 让别人知道”我不知道怎么去说，让我的子类去说吧“
	/*
	public void sayHello()
	{
//		System.out.println("hello");
	}
	*/
	abstract public void sayHello(); //抽象方法：不能有方法体
	//abstract的方法表示：这个方法我不知道怎么去实现
	public void dance()
	{
		System.out.println("跳舞");
	}
	public void welcome()
	{
		sayHello();
		dance();
	}
}
