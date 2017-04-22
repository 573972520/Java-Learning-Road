package com.rupeng.test.static1;

public class PersonTest1
{
	public static void main(String[] args)
	{
		Person p1 = new Person();
		p1.setAge(6);
		System.out.println(Person.TotleCount);
		Person p2 = new Person();
		p2.setAge(6);
		System.out.println(Person.TotleCount);
		Person p3 = new Person();
		p3.setAge(6);
		System.out.println(Person.TotleCount);
		Dog d1 = new Dog();
		System.out.println(Person.TotleCount);
		
		//MathTest.PI = 0.001;//无法修改，因为static变量前面加上了final——只能读取，不能赋值
		double mj = MathTest.PI*3*3;
		System.out.println(mj);
		//static方法
		Person.sayHello();
	}
}
