package 内省;

public class Dog extends IntrospectorTest2_BaseBean
{
	private int id;
	private String name;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public static void main(String[] args)
	{
		Dog d1 = new Dog();
		d1.setId(88);
		d1.setName("陈泽明");
		String s = d1.toString();
		System.out.println(s);
	}
}
