package com.rupeng.test.oo2;

public class son2  extends father
{
	private int height;

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public void sayHelloson2()
	{
		this.开金库();
		System.out.println("大家好，我的年龄是"+this.getAge()+"我的身高是"+this.height);
		AA++;
		System.out.println("son2 AA is"+AA);
	}
}
