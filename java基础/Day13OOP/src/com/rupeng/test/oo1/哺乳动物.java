package com.rupeng.test.oo1;

public class 哺乳动物 extends animal
{
	public 哺乳动物()
	{
		//System.out.println("1");//super之前不能写代码，super必须是第一句话
		//super();//super()的意思是调用一个无参的构造函数，如果不写super()，那么也会调用父类的默认的无参构造函数,子类的构造函数一定会调用父类的构造函数
		//不写super()相对于写super()
		super(4);//显式去调用另外一个重载的构造函数
		System.out.println("哺乳动物的构造函数");
	}
	public void 胎生()
	{
		System.out.println("小宝宝");
	}
	public void 脊柱()
	{
		System.out.println("小脊柱");
	}
}
