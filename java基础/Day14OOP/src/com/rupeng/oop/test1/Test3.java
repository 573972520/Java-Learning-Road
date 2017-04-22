package com.rupeng.oop.test1;

public class Test3
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		/*
		Chinese c1 = new Chinese();
		earthMan d1 = c1;
		d1.speak();
		c1.baiNian();
//		d1.baiNian(); //不能执行，因为是earthMan类型
		*/
		Chinese c1 = new Chinese();
		earthMan d1 = c1;
		d1.speak();
//		让Chinese类型的变量c2指向d1所指向的对象
//		Chinese c2 = d1;//不行，万一你的d1指向的是美国人的对象呢，所以编译不能通过
//		c1.speak();
		
		Chinese c2 = (Chinese)d1; //通过显式转换，告诉编译器d1指向的对象就是Chinese类型的
		c2.baiNian();
		c2.speak();
		
		
	}

}
