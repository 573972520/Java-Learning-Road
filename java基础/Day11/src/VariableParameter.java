
public class VariableParameter implements Runnable
{

	@Override
	public void run()
	{
		// TODO Auto-generated method stub

	}
	/**
	 * 计算一个数组的和
	 * @param nums 要计算的结果
	 * @return 数组的和
	 */
	static int sum (int[] nums)
	{
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
		{
			sum = sum +nums[i];
		}
		return sum;
	}
	/**
	 * 更简单的数组之和方法——如果将参数写出int...，那么编译器会将传来的参数合并成一个数组传递给方法
	 * @param nums 相对于int[] nums
	 * @return 数组的和
	 */
	
	//将sum1的方法名字改成sum是不能重载的，因为参数类似还是一样的
	static int sum1 (int... nums) //int[] nums（将传来的参数当成一个数组）
	{
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
		{
			sum = sum +nums[i];
		}
		return sum;
	}
	/**
	 * 
	 * @param age 年龄
	 * @param fatherName 父亲的名字
	 * @param names 可变长度参数——孩子名字
	 */
	static void test (int age,String fatherName,String... names)//注意可变长度参数（String... names）必须放在最后
	{
		System.out.println("fatherName is:"+fatherName+",age is:"+age);
		for (int i = 0; i < names.length; i++)
		{
			System.out.println("第"+(i+1)+"个孩子的名字是:"+names[i]);
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int s1 = sum(new int[] {3,5,99});
		System.out.println(s1);
		//sum(3,5,88); //这样是不行的
		int s2 = sum1(3,5,88,5);
		System.out.println(s2);
		test(66,"carl", "hh","gg","rr");
	}

}
