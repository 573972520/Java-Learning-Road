package OOPTest4;

public class TwoWay
{
	//成员变量初始化的第二种方式：构造方法中初始化
	private int age;    //1.先定义
	private String name;
	
	
	/*
	//成员变量初始化的第一种方式：声明时初始化
	
	//声明时初始化时，可以使用默认值
	//private int age;
	//private String name;
		
	//声明时初始化时，也可以改变默认值，设置自己需要的值
	private int age = 5;
	private String name = "carl";
	*/
		
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
	public TwoWay ()
	{
		this.age = 15;   //2.然后在构造方法赋值
		this.name = "john";
	}
	public static void main(String[] args)
	{
		TwoWay p1 = new TwoWay();
		System.out.println("age="+p1.getAge());
		System.out.println("name="+p1.getName());
	}

}
