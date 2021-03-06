package digui.one;

public class Fib {

	//斐波那契数列:0、1、1、2、3、5、8、13、21、...( 这个数列是已经确定的)
	//斐波那契数定义为:F(0) = 0, F(1) = 1, F(4) = F(3)+F(2)(n >= 2)
	//f(n) = f(n-1) + f(n-2) (n >= 2)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(9));//第9个斐波那契数是34
		System.out.println(noFib(9));
	}
	
	//求第n(n >= 0)个fib数
	
	//递推条件:fib(n-1)+fib(n-2)
	//结束条件:n == 0||n == 1
	public static int fib(int n)
	{
		if(n == 0)
		{
			return 0;
		}
		if(n == 1)
		{
			return 1;
		}
		
		return fib(n-1)+fib(n-2);
	}
	
	//非递归方法求第n(n >= 0)个fib数
	//思路:
	//f(n-2)+f(n-1) = f(n)
	//{0,1,1,2,3,5}
	//定义一个int数组，把前两个元素的值搞定，然后使用循环，依次从2到n给响应位置的元素赋值
	
	public static int noFib(int n)
	{
		int[] fibN = new int[n+1];//索引n
		fibN[0] = 0;
		fibN[1] = 1;
		for(int i = 2;i <= n;i++)
		{
			fibN[i] = fibN[i-1] + fibN[i-2];
		}
		
		return fibN[n];
	}
}
