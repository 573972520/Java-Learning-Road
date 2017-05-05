package listPractice;

import java.util.ArrayList;

public class java_collection_Test12_ListPractice
{

	public static void main(String[] args)
	{
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("ab");
		list1.add("ab324wewewef23");
		list1.add("afweweb");
		list1.add("a23gedgb");
		list1.add("e23b");

		/*
		 * //如果从前往后删除，那么会导致元素的序号发生改变，从而使输出的结果发生错误
		for (int i = 0; i < list1.size(); i++)
		{
			String s = list1.get(i);
			System.out.println("遍历到" + s + ",i=" + i);
			if (s.length() > 5)
			{
				//list1.remove(s);
				list1.remove(i);
			}
		}*/

		/*方法一
		 * //如果从后面往前删除，那么就不会发生上述的错误了
		for (int i = list1.size() - 1; i >= 0; i--)
		{
			String s = list1.get(i);
			if (s.length() > 5)
			{
				list1.remove(i);
			}
		}*/
		//方法二
		ArrayList<String> delList = new ArrayList<String>();//用于记录长度大于5的元素
		for (String s : list1)
		{
			if (s.length() > 5)
			{
				delList.add(s);//将长度大于5的元素添加到要删除的List中
			}
		}
		for (String s : delList)
		{
			list1.remove(s); //将记录在要删除的List中的元素统一删除
		}
		for (String s : list1)
		{
			System.out.println(s);
		}
	}

}
