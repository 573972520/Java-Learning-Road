
public class java_collection_Test4_hashCode方法
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		/*Object obj1 = new Object();
		System.out.println(obj1.hashCode());
		
		Object obj2 = new Object();
		System.out.println(obj2.hashCode());
		
		String str = "abc";
		System.out.println(str.hashCode());*/

		/*
		 * //没有override（重写）hashCode方法
		Person p1 = new Person(8, "carl", 130);
		System.out.println(p1.hashCode());// 结果为366712642
		//System.out.println(p1.hashCode());// 结果为366712642
		p1.setName("fsdfsdfs");
		System.out.println(p1.hashCode());// 结果为366712642
		Person p2 = new Person(8, "carl", 130);
		System.out.println(p2.hashCode());// 结果为1829164700
		 */

		/*
		 * //override（重写）hashCode方法
		Person p1 = new Person(8, "carl", 130);
		System.out.println(p1.hashCode());// 结果为333
		p1.setName("fsdfsdfs");
		System.out.println(p1.hashCode());// 结果为333
		Person p2 = new Person(8, "carl", 130);
		System.out.println(p2.hashCode());// 结果为333
		*/

		Integer i1 = 5;
		System.out.print(i1.hashCode());
	}
}

