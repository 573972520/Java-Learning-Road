package com.rupeng.oop.test1;

public class Test1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//无法创建接口的对象
		//Speakable s1 = new Speakable();//错误
		earthMan d1 = new Chinese();
		d1.cry();
		d1.speak("carl");
		
		//接口类型的变量指向实现了这个接口的类的对象
		Speakable s1 = new Chinese();
		s1.speak("john"); //可以调用Speakable声明的方法
		s1.cry();//能够调用哪些方法取决于变量的类型
		//s1.baiNian();//不能实现这个方法
		Chinese c1 = (Chinese)s1; //需要通过这种方法来调用baiNian方法
		c1.baiNian();
	}

}
