package 自定义类的Comparable;

import java.util.Arrays;

public class java_collection_Test16_Comparable
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Person p1 = new Person();
		p1.setName("cc");
		p1.setAge(18);
		p1.setPhoneNum("120");

		Person p2 = new Person();
		p2.setName("c11c");
		p2.setAge(28);
		p2.setPhoneNum("1320");

		Person p3 = new Person();
		p3.setName("c23344c");
		p3.setAge(58);
		p3.setPhoneNum("14520");

		//实现了Comparable接口的Person类
		Person[] persons = { p1, p2, p3 };
		Arrays.sort(persons);
		System.out.println(Arrays.toString(persons));
	}

}
