package OOPTest5;

public class Person
{

	private int age;
	private String name;
	private Dog petDog;
	private Person father;
	
	public Person getFather()
	{
		return father;
	}
	public void setFather(Person father)
	{
		this.father = father;
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
	public Dog getPetDog()
	{
		return petDog;
	}
	public void setPetDog(Dog petDog)
	{
		this.petDog = petDog;
	}
	public void sayHello()
	{
		System.out.println("大家好，我叫"+this.name+",我"+this.age+"岁了,"+"我的宠物狗叫"+this.getPetDog().getName());
		//或者像下面这样写
//		System.out.println("大家好，我叫"+this.name+",我"+this.age+"岁了,"+"我的宠物狗叫"+this.petDog.getName());
		System.out.println(this.getPetDog().getName()+"跟大家问好！");
		this.petDog.wangWang();
		
	}

}
