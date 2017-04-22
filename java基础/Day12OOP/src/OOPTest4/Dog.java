package OOPTest4;

public class Dog
{
	//定义了任意一个构造函数
	public Dog (int age)
	{
		this.age = age;
	}
	//必须自己给它提供一个无参构造函数（如果没有给出无参构造函数程序会报错）
	public Dog ()
	{
		
	}
	
	private int age;
	private String name;
	
	public static void main(String[] args)
	{
		Dog d = new Dog();
	}
}
