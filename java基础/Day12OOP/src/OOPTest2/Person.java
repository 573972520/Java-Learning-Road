package OOPTest2;

public class Person
{
	//定义在类内部（不是在方法里面）的变量叫：成员变量或者叫字段（Field）
	//成员变量随着对象的创建而创建。对象存在则成员变量存在
	//成员变量不需要初始化.默认值：int、double等默认值是0，对于String等类的对象则是null，对于boolean是false
	int age = 999;
	String name;
	
	//定义在方法内部的变量叫：局部变量
	//局部变量的生命周期：调用方法的时候存在
	public void setAge(int value)
	{
//		int i; //局部变量使用之前必须初始化
		int i = 5;
		System.out.println(i);
		age = value; 
	}
	
	public void setName(String name) //与成员变量重名
	{
//		name = name;(前面的name和后面的name都表示局部变量)
		//如果局部变量与成员变量重名，那么变量名默认表示局部变量
		this.name = name;//this.age表示当前对象的age成员变量，没有写this就还是默认的局部变量
		//int age ;//去掉这一行代码，没有定义一个局部变量（如果加上这行代码那么就是定义了一个局部变量）
		age = 88;
		//这里没有定义一个局部变量，所以这里的age代表的是成员变量
	}
	/*
	public void setName(String value)
	{
		name = value;
	}
	*/
	public void sayHello()
	{
		System.out.println("大家好,我是"+this.name+",我的年龄是"+age);
	}
	public static void  main(String[] args)
	{	
	
		Person p1 = new Person();//new Person()创建一个Person类的对象，Person p1 = 表示把p1指向这个对象
		p1.setName("carl");
		p1.sayHello();
	
		
		p1 = null;//null不代表任何对象，p1 = null 就是砍断p1和当前所指向对象之间的关系
		p1.sayHello();//调用p1所指向对象的sayHello方法（但是现在p1没有指向的对象，所以程序报错）
		//以后运行程序的时候，出现NullPointerException
		//解救方法：看看是哪个变量为null以及为什么为null
		
		
		/*
		f2();
		Person p1 = f3();
		p1 = null;
		*/
		new Person().sayHello();//创建一个Person对象，然后调用它的sayHello()方法（结果是大家好,我是null,我的年龄是999）
		System.gc();//建议（是建议不是一定）GC垃圾回收器去回收
		
	}
	
	static void f2()
	{
		Person p1 = new Person();
		Person p2 = p1;
		Person p3 = p2;
		p3 = null;
		p2 = new Person();
		p1 = p2;//当程序走到这的时候，Person p1 = new Person()中的new Person()对象就被销毁了，因为已经没有变量指向它了
	}
	
	static Person f3()
	{
		Person p1 = new Person();
		Person p2 = p1;
		Person p3 = p2;
		p3 = null;
		p2 = new Person();
		p1 = p2;
		return p2;
	}
}
