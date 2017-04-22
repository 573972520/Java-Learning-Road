package com.rupeng.oop.test1;

//extends:继承；类继承自父类

//接口约束了类必须实现什么方法

//继承可以和实现一起用
public abstract class earthMan implements Speakable,Eatable // implements: 类earthMan实现Speakable接口
{
	public void speak(String n)
	{
		System.out.println("我的名字是"+n);
	}
	
	//这里故意不去实现接口中的cry方法，那么就得加上abstract，并且让这个类的子类去实现cry方法
	/*
	public void cry()
	{
		System.out.println("cry!!!");
	}
	*/
	
	public void eat()
	{
		
	}
}
