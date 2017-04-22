package com.rupeng.oop.test;

public class Test3
{

	public static void main(String[] args)
	{
		final int i = Integer.parseInt("142323");
		final String s = "haha";
		final int j;
		j = 6;
		//j = 8;//final变量只能赋值一次
		
		// TODO Auto-generated method stub
		earthMan d1 = new earthMan()
		{
			@Override
			public void speak()
			{
				// TODO Auto-generated method stub
				System.out.println("我是匿名类"+i+s); //匿名内部类中访问外部方法中的局部变量的时候，那个局部变量必须声明final
				//但是JDK8开始就不用加final了
			}
		};
		d1.welcome();
	}
}		
				/*
				 * //经过反编译得知，其实原理上来讲，并不是匿名类中访问了局部变量，而是匿名类中定义了成员变量和有参构造函数，局部变量是以调用构造函数的参数的形式传递的
				class Test3$1 extends earthMan
				{
					int val$i;
					String val$s;
					public Test3$1(int paramInt, String paramString)
					{
						// TODO Auto-generated constructor stub
						this.val$i = paramInt;
						this.val$s = paramString;
					}
					public void Speak()
					{
						System.out.println("我是匿名类"+this.val$i+this.val$s);
					}
				}
				earthMan d1 = new Test3$1(i,s)
				*/
			
		
		
	
		
	

