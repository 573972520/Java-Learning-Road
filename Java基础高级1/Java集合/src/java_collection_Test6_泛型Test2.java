
public class java_collection_Test6_泛型Test2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyClass1<String, Integer> m1 = new MyClass1<String, Integer>();
		m1.hello("wdf3", 22);
		//m1.hello("23sd", "23s");//报错
		int i = m1.m2(231);
		System.out.println(i);
		m1.hi(23, "23erd", "23erd");

		MyClass1<Boolean, Double> m2 = new MyClass1<Boolean, Double>();
		double d = m2.m2(21323.234);
		System.out.println(d);
	}

}
