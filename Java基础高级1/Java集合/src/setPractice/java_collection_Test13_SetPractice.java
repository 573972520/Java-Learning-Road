package setPractice;

import java.util.HashSet;
import java.util.Set;

public class java_collection_Test13_SetPractice
{
	//不重复元素个数
	public static void main(String[] args)
	{
		Set<Integer> setArray = new HashSet<Integer>();
		int[] nums = { 34, 4, 2, 7, 7, 4, 78, 9, 23, 9 };
		/*自己写的
		 * for (int i = 0; i < nums.length; i++)
		{
			int j = nums[i];
			setArray.add(j);
		}*/
		//老师写的
		for (int i : nums)
		{
			setArray.add(i);
		}
		System.out.println("个数为" + setArray.size());
		for (int i : setArray)
		{
			System.out.println(i);
		}
	}
}
