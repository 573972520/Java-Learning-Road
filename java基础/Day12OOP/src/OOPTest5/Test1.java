package OOPTest5;

public class Test1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Dog d1 = new Dog();
		d1.setAge(5);
		d1.setType("泰迪");
		d1.setName("泽明");
		Dog d2 = new Dog();
		d2.setAge(7);
		d2.setType("藏獒");
		d2.setName("航硕");
		
		Person p1 = new Person();
		p1.setAge(8);
		p1.setName("carl");
		p1.setPetDog(d1);
		
		p1.sayHello();
		
		
		System.out.println("狗的品种是"+p1.getPetDog().getType());
		//上面输出的代码中p1.getPetDog().getType()相对于下面两句代码的集合
		//Dog d2 = p1.getPetDog();
		//d2.getType();
		
		Person p2 = new Person();
		p2.setAge(80);
		p2.setName("FUCK");
		p2.setPetDog(d2);
		p2.sayHello(); 
		
	}

}
