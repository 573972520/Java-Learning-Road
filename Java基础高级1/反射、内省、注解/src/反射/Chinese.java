package 反射;

public class Chinese extends Person
{
	private int aa = 5;
	public int Count = 8;
	public Chinese()
	{

	}

	public Chinese(int age, String name)
	{
		this.setAge(age);
		setName(name);
	}

	public Chinese(String name)
	{
		setName(name);
	}

	public void hello(String s)
	{
		System.out.print("hello" + s);
	}
	public void hello()
	{
		System.out.print("hello");
	}

	public void eat()
	{
		System.out.print("eat");
	}

	public void speak(String s)
	{
		System.out.print("说出来" + s);
	}
}
