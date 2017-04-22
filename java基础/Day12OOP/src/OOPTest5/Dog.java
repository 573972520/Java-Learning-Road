package OOPTest5;

public class Dog
{
	private String name;
	private String type;
	private String favriateFood;
	private int age;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getFavriateFood()
	{
		return favriateFood;
	}
	public void setFavriateFood(String favriateFood)
	{
		this.favriateFood = favriateFood;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public void wangWang()
	{
		for (int i = 0; i < age; i++)
		{
			System.out.println("Íô");
		}
	}
}
