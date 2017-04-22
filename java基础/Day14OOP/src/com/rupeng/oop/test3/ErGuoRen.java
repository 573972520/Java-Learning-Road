package com.rupeng.oop.test3;

public abstract class ErGuoRen extends earthMan
{

//	俄国人继承地球人，但是俄国人不知道怎么去实现抽象的sayHello方法，那么就在俄国人的类上也加上abstract
//	并且让它的儿子——莫斯科人去实现抽象的sayHello方法
	
	public void fight()
	{
		System.out.println("Kill!");
	}
}
