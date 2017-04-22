package OOPTest4;

public class Person
{
	private int age;
	private String name;
	
	public int getAge()
	{
		return this.age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	//构造方法：方法名和类名一样，没有返回值
	//在new对象的时候调用
	public Person()
	{
		this.age = 5;
//		this.age = (int)System.currentTimeMillis();
		this.name = "FUCK";
	}
	public Person (int age)
	{
		this.age = age;
		this.name = "NoFUCK";
	}
	public Person (int age,String name)
	{
		this.age = age;
		this.name = name;
	}
	public static void main(String[] args)
	{
		Person p1 = new Person();//调用无参数的构造函数
		System.out.println("age="+p1.getAge());
		System.out.println("name="+p1.getName());
		Person p2 = new Person(88);//调用有参数(age)的构造函数
		System.out.println("age="+p2.getAge());
		System.out.println("name="+p2.getName());
		Person p3 = new Person(66,"hello");//调用有参数(age,name)的构造函数
		System.out.println("age="+p3.getAge());
		System.out.println("name="+p3.getName());
	}
	
	
}
