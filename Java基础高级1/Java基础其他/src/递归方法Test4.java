
public class 递归方法Test4
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//		story();
		int result = jiecheng(4);
		System.out.println(result);
	}

	//讲故事的方法
	public static void story()
	{
		System.out.println("从前有个庙，庙里面有一个老和尚，老和尚在和小和尚讲故事，讲的故事是：");
		story();
	}

	//自然数n的阶乘  n! = n*(n-1)*...*3*2*1,其中0!=1;也可以表示为 n! = n*(n-1)!  其中0!=1
	public static int jiecheng(int n)
	{

		if (n > 0)
		{
			//递归规则：n*jiecheng(n-1)
			int result = n * jiecheng(n - 1);
			return result;
		} else
		{
			//返回条件：jiecheng(0)=1
			return 1;
		}
	}


}
