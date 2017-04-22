package com.rupeng.oop.test;

public class Test2
{
	public static void main(String[] args)
	{
		//earthMan d1 = new Test2&1();
		//不是new的抽象类的对象，new的是抽象类的子类的对象
		//匿名类要把父类的所有 抽象方法都实现，匿名类也可以override父类中的普通方法
		earthMan d1 = new earthMan()
		{
			private int age;
			public int getAge()
			{
				return this.age;
			}
			public void setAge(int age)
			{
				this.age = age;
			}
			//因为使用匿名类对象的时候变量类型都是父类的类型，所以无法调用匿名类中自己定义的方法，所以一般不在匿名类中声明新方法
			@Override
			public void speak()
			{
				// TODO Auto-generated method stub
				System.out.println("我是地球人的一个匿名的孩子1");
			}
			@Override
			public void dance()
			{
				// TODO Auto-generated method stub
				System.out.println("欧巴nice");
			} 
		};
		d1.welcome();
	}
}
  