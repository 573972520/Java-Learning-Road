package digui.one;

public class jiecheng {

	//阶乘
	//n的阶乘表示为n!
	//0的阶乘等于1----0! = 1
	//自然数n的阶乘等于1*2*3*....n! =
	//n! = n*(n-1)*(n-2)*...2*1
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  i = 5;
		System.out.println(jieCheng(i));
		System.out.println(noJieCheng(i));
	}
	//编写一个方法求自然数n的阶乘
	//分析：由于n! = n*(n-1)*(n-2)*...2*1
	//	并且(n-1)! = (n-1)*(n-2)*...2*1
	//	所以n! = n*(n-1)!
	
	//递推条件:n*jiecheng(n-1)
	//返回条件 :n == 0
	public static int jieCheng(int n)
	{
		//返回条件
		if(n == 0)
		{
			return 1;
		}
		//递推条件
		int jiechengN = n*jieCheng(n-1);
		
		return jiechengN;
	}
	
	
	//非递归方法求阶乘
	public static int noJieCheng(int n)
	{
		if(n == 0)
		{
			return 1;
		}
		int jiechengN = 1;
		for(int i = 1;i <= n;i++){
			jiechengN = jiechengN * i;
		}
		return jiechengN;
	}
	
	//递归方式和非递归方式的比较
	//递归方式的缺点：内存开销大，性能不高
	//递归方式的优点：代码实现非常简洁
	//非递归方式的缺点就是递归的优点(反之亦然)

}
