import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class java_collection_Test3_Java内置的List
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add("123");
		list.add("rupeng");
		list.add(1, "baidu");//在1的位置插入baidu
		list.remove(3);//删除第四个元素
		list.remove("abc");//删除内容为abc的元素
		System.out.println(list.size());//2
		list.clear();//清空
		System.out.println(list.size());//0
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}

		//数组中是否包含如下数据
		System.out.println(list.contains("hello")); //false
		System.out.println(list.contains("123"));//true

		//转换成固定长度的数组
		Object[] objs = list.toArray();

		LinkedList list2 = new LinkedList();
		list.add("123");

		List list3 = new ArrayList();
	}

}
