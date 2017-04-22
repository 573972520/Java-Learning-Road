package com.rupeng.test.static1;

public class GodTest1
{
	public static void main(String[] args)
	{
		God.getGod().ZhaoYaoDaDi();
		God g1 = God.getGod();
		God g2 = God.getGod();
		System.out.println(g1 == g2); //true 两个变量是否指向同一个对象
		
//		God g3 = new God();  //如果没有在God中加private God(){} 那么还是可以新建出来一个对象//

//		System.out.println(g3 == g1); //false
		
		/*
		单例模式：
		目的：系统中有且只有这个类的一个对象
		步骤：
		1、声明一个静态对象  private static God instance = new God();
		2、提供一个供外界访问这个对象的static方法
		public static God getGod()
		{
			return instance;
		}
		3、为了避免其他人new这类的对象，把类的构造函数改成private
		private God() //作用：不能让其他人new一个对象
		{
			
		}
		调用者只能使用God.getGod()拿到这个唯一的对象
		*/
		
	}
}
