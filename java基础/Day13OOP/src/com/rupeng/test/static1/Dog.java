package com.rupeng.test.static1;

public class Dog
{
	public Dog ()
	{
		
		Person.TotleCount--;//在其他类中调用static成员的时候需要带上类名
		
		Person.sayHello();
	}
}
