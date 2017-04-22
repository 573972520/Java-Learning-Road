package com.rupeng.test.oo2;

public class father
{
	public static int AA;
	private int age; //private连子类都不可以访问
	int count = 8;
	public int getAge()
	{
		return age;
	}
	protected void 开金库()
	{
		System.out.println("开金库");
	}
	
	void Default方法()
	{
		
	}
	public void setAge(int age)
	{
		if (age < 0||age > 150)
		{
			System.out.println("年龄非法");
		}
		this.age = age;
	}
	public void sayHello()
	{
		System.out.println("我的年龄"+this.age);
		AA++;
		System.out.println("father AA is"+AA);
	}
}
