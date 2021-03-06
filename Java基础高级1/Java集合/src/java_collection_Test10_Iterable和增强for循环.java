import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class java_collection_Test10_Iterable和增强for循环
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(43);
		list1.add(34);

		/*使用Iterable进行循环,但 是十分麻烦，所以可以使用增强for循环
		 * Iterable<Integer> it1 = list1;
		Iterator<Integer> itor1 = it1.iterator();
		while (itor1.hasNext())
		{
			Integer v = itor1.next();
			System.out.println(v);
		}*/

		//遍历list1中的每一个元素，v代表每次循环拿到的元素
		for (Integer v : list1)
		{
			//list1.add(343);//不要在进行遍历的时候增加或者移除元素，这样会造成并发问题
			System.out.println(v);
		}

		Queue<String> q1 = new LinkedList<String>();
		q1.add("ad");
		q1.add("213qw");
		for (String s : q1)
		{
			System.out.println(s);
		}

		int[] nums = { 1, 23, 34, 43 };
		for (int i : nums)
		{
			System.out.println(i);
		}
	}

}
