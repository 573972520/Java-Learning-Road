package 自定义类的Comparable;

public class Person2
{
	private String name;
	private int age;
	private String phoneNum;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getPhoneNum()
	{
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
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
		if(!(obj instanceof Person2))
		{
			return false;
		}
		Person2 pObj = (Person2)obj;
		return this.name.equals(pObj.name) && this.age == pObj.age && this.phoneNum.equals(pObj.phoneNum);

	}

	//equals为true，那么hashCode一定一样，但是hashCode一样，equals不一定true，因为hashCode有时候会一样
	@Override
	public int hashCode()
	{
		String s = this.name + this.age + this.phoneNum;
		return s.hashCode();
	}
}
