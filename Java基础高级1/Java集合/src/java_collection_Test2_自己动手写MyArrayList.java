
public class java_collection_Test2_自己动手写MyArrayList
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyArrayList l1 = new MyArrayList();
		l1.add("fuck");
		l1.add("shit");
		l1.add("carl");
		l1.add("java");
		l1.add("shit1");
		System.out.println(l1.size()); //5
		l1.add("tokyohot");
		l1.add("fuck1");
		l1.add("shit1");
		l1.add("carl1");
		l1.add("fuck55");
		l1.add("fuck35");
		l1.add("shit66");
		l1.add("car99l");
		System.out.println(l1.size());//13
		Object obj = l1.get(10);
		System.out.println(obj);//fuck35

		//遍历数组元素
		for (int i = 0; i < l1.size(); i++)
		{
			Object obj1 = l1.get(i);
			System.out.println(obj1);
		}
	}

}
