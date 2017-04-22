package com.rupeng.test.oo1;

public class Test1
{
	public static void main(String[] args)
	{
		/*
		人类 human = new 人类();
		human.直立行走();
		human.进食();
		human.玩手机();
		human.脊柱();
		
		牛 cow = new 牛();
		cow.耕地();
		//cow.玩手机(); 不能继承人类
		
		//因为所有的类都直接或者间接继承自Object，所以toString、getClass、hashCode等方法都定义在Object中
		//Object是所有的类的直接或间接父类
		human.toString();
		human.getClass();
		human.hashCode();
		*/
		//父类子类的构造函数
		人类 human = new 人类();
		human.玩手机(); //结果是：动物的构造函数
		 			  //哺乳动物的构造函数
					  //人类的构造函数
					  //玩手机
		//在父类中增加了重载之后，子类默认还是会调用无参的构造函数，
		//但如果在子类中增加super()，那么便会调用对应的有参的构造函数了
		
	}
}
