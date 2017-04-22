package com.rupeng.test.static1;

public class God
{	
	private static God instance = new God();
	public static God getGod()
	{
		return instance;
	}
	private God() //作用：不能让其他人new一个对象：
	{
		
	}
	public void ZhaoYaoDaDi()
	{
		System.out.println("你们会幸福的！");
	}
}
