package 自定义类的Comparable;

import java.util.Arrays;
import java.util.Comparator;

public class java_collection_Test17_Comparable
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Person2 p1 = new Person2();
		p1.setName("cc");
		p1.setAge(18);
		p1.setPhoneNum("120");

		Person2 p2 = new Person2();
		p2.setName("c11c");
		p2.setAge(28);
		p2.setPhoneNum("1320");

		Person2 p3 = new Person2();
		p3.setName("c23344c");
		p3.setAge(58);
		p3.setPhoneNum("14520");

		//没有实现了Comparable接口的Person2类
		Person2[] persons2 = { p1, p2, p3 };
		Arrays.sort(persons2, new Comparator<Person2>()
		{
			@Override
			public int compare(Person2 o1,Person2 o2)
			{
				return o1.getAge() - o2.getAge();
			}
		});
		System.out.println(Arrays.toString(persons2));
	}

}
