import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class java_collection_Test6_泛型Test3
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String[] strs = { "ada", "234s", "234s" };
		Object[] objs = strs; //用父类相关类型的变量指向子类相关类型的对象——协变
		for(int i = 0;i < objs.length;i++)
		{
			System.out.println(objs[i]);
		}

		/*LinkedList<String> list2 = new LinkedList<String>();
		//LinkedList<Object> list3 = list2; //报错，因为泛型不支持协变
		HashMap<String, Double> map1 = new HashMap<String, Double>();
		//HashMap<Object, Double> map2 = map1;//报错，因为HashMap不支持协变
		*/

		LinkedList<String> list2 = new LinkedList<String>();
		list2.add("asd");
		list2.add("33");
		LinkedList list3 = list2;

		ArrayList list4 = new ArrayList<Integer>(); //经过反编译查看之后，这行代码变成了：ArrayList list4 = new ArrayList();
		//这说明不管后面是否加上泛型，但是编译出来是不加泛型的
		list4.add(23);
		list4.add("3weasd4"); //可以传入String类型，不报错以
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

		ArrayList<Integer> list5 = new ArrayList();
		list5.add(343);
		//list5.add("34f");//报错

		HashMap<String, Double> map1 = new HashMap();
		HashMap map2 = new HashMap<String, Integer>();

	}
}
