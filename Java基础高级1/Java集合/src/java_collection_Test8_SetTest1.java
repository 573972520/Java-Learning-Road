import java.util.HashSet;

public class java_collection_Test8_SetTest1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//Set<String> set1 = new HashSet<String>();
		HashSet<String> set1 = new HashSet<String>();
		set1.add("3");
		set1.add("abc1");
		set1.add("3");
		set1.add("3");
		set1.add("3");
		set1.add("abc");
		Object[] arr1 = set1.toArray();
		System.out.println(arr1.length);//长度是3
		for (int i = 0; i < arr1.length; i++)
		{
			System.out.println(arr1[i]); //结果不会重复
		}
		System.out.println(set1.contains(3)); //false
		System.out.println(set1.contains("3")); //true
	}

}
