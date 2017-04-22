
public class PersonTest1
{

	public static void main(String[] args)
	{
		
		/*
		//创建Person类的一个对象（实例Instance）,用Person类的变量p1指向这个对象
		Person p1 = new Person(); //创建了一个人类的对象（实例）
		p1.setAge(1); //调用p1当前所指对象的setAge方法
		p1.setHeight(180);
		p1.setName("carl");
		p1.sayHello();
		
		Person p2 = new Person();// 又创建一个人类的对象（实例）
		p2.setAge(18); //调用p2当前所指对象的setAge方法
		p2.setHeight(150);
		p2.setName("john");
		p2.sayHello();
		//每new一次就创造一个新的对象，对象的普通变量是“每一个对象一份”，不互相干扰
		//各个对象之间对于普通变量的修改只是影响自己对象里的那一份
		p1.sayHello();//这里打印出carl
		*/
		
		
		/*
		int i = 20;
		int j = i;//把i的当前值赋值给j
		i = 30;
		System.out.println(j); //结果是20
		
		//以上面变量赋值的案例，引出对象赋值的例子
		
		Person p1 = new Person();
		p1.setAge(1); 
		p1.setHeight(180);
		p1.setName("火山");
		p1.sayHello();
		
		Person famousMan = p1;//把p1当前所指向的对象赋值给famousMan
		famousMan.sayHello();
		
		//一个变量只能指向一个对象
		p1 = new Person();//创建一个Person类的对象，把它赋值给p1
		p1.setAge(100); 
		p1.setHeight(80);
		p1.setName("carl");
		
		famousMan.sayHello(); //结果不变
		*/
		
		/*
		Person p1 = new Person();
		p1.setName("火山");
		p1.sayHello(); //火山
		
		Person p2 = p1;
		p2.setName("carl");
		
		p1.sayHello();//carl
		p2.sayHello();//carl
		*/
		
		
		/*
		Person p1 = new Person(); //只有new才会产生对象
		p1.setAge(55);
		p1.setHeight(552);
		p1.setName("火山");
		p1.sayHello(); //大家好,我是火山,我的年龄是55,我的身高是552.0
		
		f1(p1);
		p1.sayHello();//大家好,我是火山,我的年龄是50,我的身高是552.0
		*/
		
		
		
		Person p1 = createPerson();
		p1.setHeight(552);
		p1.setName("火山");
		p1.sayHello(); //大家好,我是火山,我的年龄是666,我的身高是552.0
		
		f1(p1);
		p1.sayHello();//大家好,我是火山,我的年龄是666,我的身高是552.0
		
		
	}
	//参数相对于方法内部的局部变量
	static Person createPerson()
	{
		Person p1 = new Person();
		p1.setAge(666);
		return p1;
	}
	static void f1 (Person p)
	{
//		p.setAge(50);
		p = new Person();
		p.setName("wokao");
	}
}
