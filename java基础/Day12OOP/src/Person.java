
public class Person//定义了一个人类
{
	//数据——相对于变量
	private int age;
	private String name;
	private double height;
	//行为——相对于方法
	public void setAge(int value)
	{
		age = value; //给当前对象的age设置为value
		//this.age = age;
	}
	public void setName(String value)
	{
		name = value;
	}
	public void setHeight(int value)
	{
		height = value;
	}
	public void sayHello()
	{
		System.out.println("大家好,我是"+name+",我的年龄是"+age+",我的身高是"+height);
	}
}

//类由“数据”和“行为”组成。数据（成员变量，Field ，字段）设置为private.
//一个java文件中只能定义一个public的class，且java文件名和public类的名字一样。
/*
public class T1 //会报错，因为定义了两个public的class
{
	
}
*/

