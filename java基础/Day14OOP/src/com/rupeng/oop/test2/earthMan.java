package com.rupeng.oop.test2;

//final的三个用途
//final 变量：public static final int a = 8；  除了初始化的时候，不能再次修改它的值
//final 方法：这个方法不能在子类中被override
//final 类 ： 这个类不能有子类。断子绝孙！ String、Integer等都是final类


//public final class earthMan 如果一个类标记为final，则这个类就不能有子类
public class earthMan
{
	//public final void speak()如果把方法标记为final，则子类中不能override这个方法，
	public void speak()
	{
		
		System.out.println("大家好，我是地球人");
	}
	public void f1()
	{
		System.out.println("f1 begin");
		speak();//相对于this.speak()  this代表当前对象，也就是Chinese
		//所以如果this是Chinese对象，并且Chinese有override的speak方法 ，则调用Chinese的speak
		System.out.println("f1 end");
	}
}
