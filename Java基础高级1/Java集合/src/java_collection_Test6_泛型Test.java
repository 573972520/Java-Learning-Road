import java.util.ArrayList;
import java.util.LinkedList;

public class java_collection_Test6_泛型Test
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(12);
		//list.add("23");//会报错，因为参数类型必须是Integer类型
		list.add(23);
		int sum = sum(list);
		System.out.println(sum);

		ArrayList<String> list1 = new ArrayList<String>();
		//list1.add(12);//会报错，因为参数类型必须是String类型
		list1.add("23");
		
		LinkedList<Boolean> list3 = new LinkedList<Boolean>();//这里要使用首字母大写的boolean包装类型——Boolean 
		list3.add(false);
	}

	static int sum(ArrayList<Integer> list)
	{
		int rusult = 0;
		for (int i = 0; i < list.size(); i++)
		{
			int sum = list.get(i);
			rusult += sum;
		}
		return rusult;
	}

}
