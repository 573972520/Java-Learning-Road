import java.util.ArrayList;

public class java_collection_Test6_泛型简介
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		//当添加的数据类型是Int类型时，能运行成功
		/*
		ArrayList list1 = new ArrayList();
		list1.add(5);
		list1.add(3);
		int s = sum(list1);
		System.out.println(s); //8
		 */

		//当添加的数据类型不是Int类型时，报错
		ArrayList list2 = new ArrayList();
		list2.add(5);
		list2.add(3);
		list2.add("5");//无法限制list中只能放int，需要一种机制，限制ArrayList的参数类型
		int s1 = sum(list2);
		System.out.println(s1);// java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
	}

	static int sum(ArrayList list)
	{
		int result = 0;
		for (int i = 0; i < list.size(); i++)
		{
			//int value = (int) list.get(i);//错误
			int value = (Integer) list.get(i);//正确
			result += value;

			/*上面的int value = (Integer) list.get(i)相对于
			Integer i1 = (Integer)list.get(i);//先将Object类型转换成Integer类型
			int value = i1;//拆箱——再将Integer转换成Int类型
			*/
		}
		return result;
	}
}
