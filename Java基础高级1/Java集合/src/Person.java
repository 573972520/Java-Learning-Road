
public class Person
{

	private int age;
	private String name;
	private int height;

	public Person(int age, String name, int height)
	{
		super();
		this.age = age;
		this.name = name;
		this.height = height;
	}

	@Override
	public int hashCode() //重写hashCode方法
	{
		String s = this.age + this.name + this.height;
		return s.hashCode();
	}
	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}


}
