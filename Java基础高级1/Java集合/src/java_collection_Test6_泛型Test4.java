import java.util.ArrayList;

public class java_collection_Test6_泛型Test4
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ArrayList list4 = new ArrayList<Integer>(); //经过反编译查看之后，这行代码变成了：ArrayList list4 = new ArrayList();
		//这说明不管后面是否加上泛型，但是编译出来是不加泛型的
		list4.add(23);
		list4.add("3weasd4"); //可以传入String类型，不报错
		//		for (int i = 0; i < list4.size(); i++)
		//		{
		//			System.out.println(list4.get(i));
		//		}

		ArrayList<Integer> list6 = list4;
		list6.add(55);
		//list6.add("23");//如果list6不加泛型那么这行代码不会报错，如果加了泛型，那么就报错
		for (int i = 0; i < list6.size(); i++)
		{
			System.out.println(list6.get(i));//结果：23,3weasd4,55
		}

		boolean b1 = list6 instanceof ArrayList;
		System.out.println(b1);

		//boolean b2 = list6 instanceof ArrayList<Integer>;//报错
		//System.out.println(b2);

	}

	static void f1(Integer i)
	{

	}

	static void f1(String s)
	{

	}

	/*static void f1(ArrayList i1)
	{
	
	}
	static void f1(ArrayList<Integer> i1) //会被插除成ArrayList i1，故不能构成重载
	{
	
	}*/

}
