
public class MethodTest implements Runnable
{

	@Override
	public void run()
	{
		// TODO Auto-generated method stub

	}

	// 返回值：就是这段重复使用的代码执行结束后返回给调用者的结果
	// 方法名：调用这个重复使用的代码的时候，使用什么名字
	// 参数：调用这个方法的时候需要传递给代码段的信息
	// 方法体：就是重复使用的代码，——使用传递过来的参数进行运算，并且把运算的结果以返回值的形式返回
	static int add(int i1, int i2)
	{
		if (i2 > i1)
		{
			return i2 - i1;
		} else
		{
			return i2 + i1;
		}
	}

	static int max(int[] nums)
	{
		int max = nums[0];
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] > max)
			{
				max = nums[i];
			}
		}
		return max;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int j1 = add(5, 6);// j1就得到了这次调用add方法的返回值
		int j2 = add(6, 5);// 给参数执行方法，并且拿到返回值
		//上面的代码 —— 两次调用之间，内部数据是隔离的
		System.out.println(j1);
		System.out.println(j2);
		int i3 = 888;
		int i4 =add(i3, j1);
		System.out.println(i4);
		int i1 =6;
		int i2 = 5;
		int w = add(i2, i1);//add方法定义在main外部，只是在main中“调用”（a方法不能调用b方法内部的局部变量）
		System.out.println(w); //结果是1，因为传给方法的参数与定义的变量没有关系

		int[] nums1 ={ 4, 6, 9, 121, 52, 1 };
		int max = max(nums1);
		System.out.println(max);
	}

}
