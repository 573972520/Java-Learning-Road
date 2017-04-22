package com.rupeng.oop.test;

public class Test4
{

	public static void main(String[] args)
	{
		Test4 t4 = new Test4();
		t4.setAge(88);
		t4.f1();
	}
	private int age;
	
	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	void f1()
	{
		earthMan d1 = new earthMan()
		{
			private int age = 77;
			@Override
			public void speak()
			{
				// TODO Auto-generated method stub
				int age = 999;
				System.out.println("我的年龄是"+age);
				System.out.println("我的年龄是"+this.age); //如果没有private int age = 77;上面的代码，那么会报错    因为this指的是匿名内部类的对象
				System.out.println("我的年龄是"+Test4.this.age);//在匿名内部类中，访问外部类的当前对象成员的时候，使用“外部类的类名.this“进行访问
			}
		};
		d1.welcome();
	}
}
