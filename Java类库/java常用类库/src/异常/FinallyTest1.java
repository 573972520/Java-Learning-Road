package 异常;

public class FinallyTest1 {

	public static void main(String[] args) {
		try 
		{
			int[] nums = {3,5,9};
			System.out.println(nums[9]);//超出数组范围
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("数组超出范围");
		}
		finally//一般用于资源的回收
		{
			System.out.println("我是finally"); //无论程序是否有异常，finally中的代码都会执行
		}
		//final（声明在一个变量上，用来表示它不能被重新赋值）（一个类被声明为final，表示这个类能再派生出新的子类，不能作为父类被继承。）（方法上标记final，这个方法不能被重载）
		//finally
	}

}
