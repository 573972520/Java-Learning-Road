package com.rupeng.test.oo2;

public class son extends father
{
	private String name;

	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void sayHelloSon()
	{
		this.setAge(888);
		
		System.out.println("您好,我是"+this.name+"我"+this.getAge()+"岁了");
		AA++;
		System.out.println("son AA is"+AA);
	}
}
