package com.rupeng.oop.test1;

import org.w3c.dom.css.RGBColor;

public class test2
{

	
	public static void main(String[] args)
	{
		
		/*
		// TODO Auto-generated method stub
		Chinese man = new earthMan();
		//可以调用哪些方法由变量的类型决定
		man.speak();
		//如果Chinese man = new earthMan();是可以的话
		//那么man.baiNian();就会调用earthMan对象的方法
		//java编译器为了防止我们犯错，禁止这样：把一个子类的变量指向父类的对象（这是错误的）
		//例如Chinese man = new earthMan();(错误)
		man.baiNian();
		*/
		//创建一个Chinese对，让earthMan类型的变量指向它（可以的）
		earthMan man = new Chinese();//父类类型的变量可以指向子类类型的对象
		man.speak();//调用man指向对象的speak方法
		//因为man指向的是chinese对象，所以调用的speak是chinese的speak
		//可以调用那些方法由变量的类型决定
		//man.baiNian();
		
		//变量其实就是一个标签，用来“指向”（贴到）某个对象上
		
		earthMan d1 = new BeiJingMan();
		d1.speak();
		
		earthMan man2 = createMan(); //只有new才会产生对象，在方法内部已经new了
		man2.speak();
		
		Chinese man3 = createMan1();
		man3.speak();
	}
	
	//返回一个earthMan类型（或者子类类型）的对象
	public static earthMan createMan()
	{
//		return new earthMan();
		return new Chinese();
//		return new BeiJingMan();
	}
	
	public static Chinese createMan1()
	{
		//return new earthMan();//子类不能返回父类对象
//		return new Chinese();
		return new BeiJingMan();
	}
	
}
