package OOPTest3;

public class Person
{
	//javabean编程规范：把数据（成员变量）声明为private，读取使用get***方法，设置采用set***方法
	//getter(获取)指的就是get方法，setter(设置)指的就是set方法
	
	//private（私有）成员特征：只能在当前类中访问，不能被其他类访问
	private int age;
	private String name;
	
	//什么都不写代表default（同一个包中可以访问）
	//int age;  
	//String name;
	
	//public代表在其他类中也可以访问
	//public int age;  
	//public String name;
	
	/**
	 * 设置当前人的年龄
	 * @param age 年龄
	 */
	public void setAge(int age)
	{
		if (age < 0)
		{
			System.out.println("年龄不能为负数");
			return;
		}
		this.age = age;
	}
	/**
	 * 设置当前人的姓名
	 * @param name 姓名
	 */
	public void setName(String name)
	{
		if (name == null)
		{
			System.out.println("没有传入字符串对象");
			return;
		}
		if (name.length() > 5)
		{
			System.out.println("姓名长度不能大于5");
			return;
		}
		this.name = name;
	}
	/**
	 * 获得当前人的年龄
	 * @return 年龄
	 */
	public int getAge ()
	{
		return this.age;
	}
	/**
	 *  获得当前人的姓名
	 * @return 姓名
	 */
	public String getName ()
	{
		return this.name;
	}
	
	public void sayHello()
	{
		System.out.println("大家好,我是"+this.name+",我的年龄是"+this.age);
	}
}
