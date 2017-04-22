package com.rupeng.test.static1;


public class Person
{
	
	//对于static变量，所有的对象共享同一份
	public static int TotleCount = 0;
	
	public Person()
	{
		TotleCount++; //在自己类内部调用成员变量的时候不需要写类名
	}
	private int age;

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		f1();//非static成员可以访问static成员
		this.age = age;
	}
	//static方法
	public static void f1()
	{
		
	}
	public static void sayHello()
	{
		f1();//static成员可以调用static成员
		//setAge(56);//static成员不能直接访问非static成员
		
		//static成员间接访问非static成员（通过一个Person对象来调用方法）
		Person p1 = new Person();
		p1.setAge(55);
		
		System.out.println("你们好，我是地球人，我们有"+TotleCount+"人");
		//System.out.println("你们好，我是地球人，我们有"+TotleCount+"人,我的年龄是"+this.age);//报错，因为this代表当前对象，但是现在的当前对象是没有的并且static是独立于对象而存在的。
	}
	
	
}
