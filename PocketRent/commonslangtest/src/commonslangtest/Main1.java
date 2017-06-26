package commonslangtest;

import org.apache.commons.lang3.ArrayUtils;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,6,8};
		int[] newNums = ArrayUtils.add(nums, 555);
		int[] num3 = ArrayUtils.addAll(nums, 333,555,2122);
		int[] num4 = new int[0];
		int[] num5 = null;
		/*
		for(int i : nums)
		{
			System.out.println(i);
		}*/
		
		/*
		System.out.println(ArrayUtils.toString(nums));
		System.out.println(ArrayUtils.toString(newNums));
		System.out.println(ArrayUtils.toString(num3));
		System.out.println(ArrayUtils.contains(num3, 555));
		System.out.println(ArrayUtils.isEmpty(num4)); //true 数组是空的
		System.out.println(ArrayUtils.isEmpty(num5)); //true
		*/
		
		
		//Integer[] nunm9 = nums; //java  中原始类型的数组和包装类型的数组之间无法直接赋值
		Integer[] nunm9 = ArrayUtils.toObject(nums); 
		Integer[] nunm10 = toObject(nums); 
		System.out.println(ArrayUtils.toString(nunm9));
		System.out.println(ArrayUtils.toString(nunm10));
		
		int[] nums11 = ArrayUtils.toPrimitive(nunm9);
		System.out.println(ArrayUtils.toString(nums11));
		
	}
	static Integer[] toObject(int[] nums)
		{
			Integer[] objs = new Integer[nums.length];
			for(int i = 0;i<nums.length;i++)
			{
				objs[i] = nums[i]; //装箱
			}
			return objs;
		}

}

		