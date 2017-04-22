package com.rupeng.oop.game;

public class Test2
{
	private int age;
	public void f1()
	{
		Flyable f1 = new Flyable()
		{
			
			@Override
			public void fly()
			{
				// TODO Auto-generated method stub
				System.out.println(Test2.this.age);
			}
		};
		f1.fly();
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		/*
		earthMan d1 = new Chinese();
		d1.welcome();
		
		earthMan d2 = new earthMan()
		{
			
			@Override
			public void speak()
			{
				// TODO Auto-generated method stub
				System.out.println("我是匿名人");
			}
		};
		d2.welcome();
		*/
		
		//定义一个实现了Flyable接口的匿名类，然后创建他的对象
		//用flyable类型的变量f1指向这个对象
		//匿名类只能继承自一个父类，或者实现一个接口
		
		int i = 5;
		Flyable f1 = new Flyable()
		{
			
			@Override
			public void fly()
			{
				// TODO Auto-generated method stub
				System.out.println("匿名的飞"+i);
			}
		};
		f1.fly();
	}

}

abstract class earthMan
{
	public abstract void speak();
	public void dance()
	{
		System.out.println("dance!!");
	}
	public void welcome()
	{
		speak();
		dance();
		speak();
	}
}

class Chinese extends earthMan
{
	@Override
	public void speak()
	{
		// TODO Auto-generated method stub
		System.out.println("我是中国人");
	}
}