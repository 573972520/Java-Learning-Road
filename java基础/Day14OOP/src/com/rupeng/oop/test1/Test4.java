package com.rupeng.oop.test1;

import javax.swing.JPanel;

public class Test4
{
	public static void main(String[] args)
	{
		/*
		Japanese j1 = new Japanese();
		earthMan d1 = j1;
		d1.speak();
		Chinese c2 = (Chinese)d1; //通过显式转换保证d1一定指向的是Chinese类型的对象
		//所以虽然编译器不会报错，但是运行会出现ClassCastException类型转换异常
		//如果不做显式转换，那么编译便会报错，如果做了显示式转换，如果和保证的不一致，运行时会报错么
		c2.baiNian();
		c2.speak();
		
//		Dog d3 = (Dog)d1; //显式转换只能在父子类中进行（类型转换只能在有父子关系的类中进行）
//		String s1 = "123";
//		int i = (String)s1;
		*/
		
		
		//super
		earthMan d1 = new Chinese();
		d1.speak();
		
		hello(new earthMan());
		hello(new Japanese());
		hello(new BeiJingMan());
		
		Chinese c1 = new Chinese();
		earthMan d2 = c1;
		
		Chinese c2 = (Chinese)d2;
		
//		Dog d1 = (Dog)c2;
		
	}
	
	public static void hello(earthMan d)
	{
		d.speak();
		d.eat();
	}
	
}
