package 注解;

public class Person implements Comparable<Person>
{
	private String name;
	private int age;
	private String phoneNum;
	public int haha;

	public Person() //newInstance会调用这个无参的构造函数
	{
		this.name = "caklr";
		this.age = 50;
	}

	//	public Person(int age) 
	//	{
	//		this.age = age;
	//	}
	@MyDisplayName(displayName = "姓名")
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@MyNotPrint
	@MyDisplayName(displayName = "年龄")
	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	@MyDisplayName(displayName = "手机号")
	public String getPhoneNum()
	{
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}

	public void sayHello()
	{
		System.out.println(toString());
	}
	//创建类时没有定义toString方法，输出对象时，会输出对象的哈希值
	//写这个方法的用途就是为了方便所有类的字符串操作
	@Override
	public String toString()
	{
		return "name=" + this.name + ",age=" + this.age + ",phoneNum=" + this.phoneNum;
	}

	@Override
	public boolean equals(Object obj)
	{
		//
		//
		if(!(obj instanceof Person))
		{
			return false;
		}
		Person pObj = (Person)obj;
		return this.name.equals(pObj.name) && this.age == pObj.age && this.phoneNum.equals(pObj.phoneNum);

	}

	//equals为true，那么hashCode一定一样，但是hashCode一样，equals不一定true，因为hashCode有时候会一样
	@Override
	public int hashCode()
	{
		String s = this.name + this.age + this.phoneNum;
		return s.hashCode();
	}

	//Comparable接口中的唯一方法:如果this比o大则返回正数，如果相等则返回0，否则返回负数
	@Override
	public int compareTo(Person o)
	{
		//return this.getAge() - o.getAge();
		//return o.getAge() - this.getAge();//谁年龄大，谁就大
		return o.getName().length() - this.getName().length();//谁名字长，谁就大
	}

}
