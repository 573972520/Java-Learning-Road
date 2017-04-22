package com.rupeng.oop.test1;

public class Test
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		earthMan man = new earthMan();//创建一个earthMan类型的对象，然后让earthMan类型的变量man指向它
		man.speak();//调用d1指向的对象的speak方法
		
		Chinese china = new Chinese();
		china.speak(); //子类中若没有定义speak方法，那么就会调用父类的speak方法
		//调用的时候发现“我自己有这个方法”，我就调用自己的方法	
	}

}
