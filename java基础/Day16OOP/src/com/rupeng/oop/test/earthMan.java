package com.rupeng.oop.test;

public abstract class earthMan
{
	public void dance()
	{
		System.out.println("dance!");
	}
	public void welcome()
	{
		dance();
		speak();
	}
	/*
	public void speak()
	{
		System.out.println("I'm earth man");
	}
	*/
	public abstract void speak();
}
