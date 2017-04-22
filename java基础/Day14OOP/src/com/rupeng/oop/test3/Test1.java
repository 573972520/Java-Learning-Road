package com.rupeng.oop.test3;

public class Test1
{
	public static void main(String[] args)
	{
		earthMan man = new Chinese();
		man.sayHello();
		man.dance();
		man.welcome();
		
		earthMan mengGuMan = new MengGuRen();
		mengGuMan.dance();
		mengGuMan.sayHello();
		mengGuMan.welcome();
		
	}
}
