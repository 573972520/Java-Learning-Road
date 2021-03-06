package object方法复习;

public class java_collection_Test14_Object方法
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		/*
		 * Person p1 = new Person();
		System.out.print(p1); //Person类没有重写toString()方法,则输出:object方法复习.Person@15db9742
		//System.out.print(p1.toString());
		
		int[] nums = { 1, 24, 56 };
		System.out.println(nums);//object方法复习.Person@15db9742[I@6d06d69c
		 */
		Person p1 = new Person();
		p1.setName("cc");
		p1.setAge(18);
		p1.setPhoneNum("120");

		Person p2 = new Person();
		p2.setName("cc");
		p2.setAge(18);
		p2.setPhoneNum("120");

		Person p3 = new Person();
		p3.setName("cc");
		p3.setAge(18);
		p3.setPhoneNum("120");

		//java中的==永远都是比较是否是同一个对象，equals方法默认也是如此
		System.out.println(p1 == p2); //false  不是同一个对象
		System.out.println(p1.equals(p2)); //true  因为重写了equals方法所以相等

	}

}
