
public class MethodTest3
{
	static int f1(int i)
	{
		if (i > 0)
		{
			System.out.println("i > 0");
			return 2;// 方法执行结束之后，后面的代码就不执行了
			// 并且把return后面的值作为本次方法调用的返回值给到调用者
		}
		System.out.println("233333");
		return 8;
	}

	static int f2(int n)
	{
		for (int i = 0; i < n; i++)
		{
			System.out.println("i="+i);
			if (i==3)
			{
				return 9;
			}
		}
		return 8;
	}
	static void f3(int n)//如果没有返回值，则在需要执行结束的地方return
	{
		for (int j = 0; j < n; j++)
		{
			System.out.println(j);
			if (j == 2)
			{
				return;
				//return;  //如果在这里没有写return，那么在该方法的最后一句中编译器会自动加上return
			}
		}
	}
	static String f4(int i1,int i2){
		if (i1 > i2)
		{
			return "i1 is biger";
		}
		else if (i1 < i2) {
			return "i1 is smaller";
		}
//		else {
//			return "i1 and i2";
//		}
		return "i1 and i2";  //与上面的代码一样的效果，但是更加简单
		//必须所有的可能的条件下，都必须有返回值!!(考虑所有可能的情况)
	}
	static int f5(int n)
	{
		for (int i = 0; i < n; i++)
		{
			return i;
		}
		return 100;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
//		int i = f1(5);
//		System.out.println(i);// 会将返回的值给i
//		f1(5);// 不会将值返回，因为没有调用者！
//		int j = f1(-5);
//		System.out.println(j);
//		
//		int b = f2(6);//调用f2的时候就进入了f2方法内部执行，一直到return为之，把return的值作为返回值赋值给调用者
//		System.out.println(b);
		
		f3(5); //有return的结果是012，没有return的结果是01234
		System.out.println(f4(5, 5));
		System.out.println(f5(5));
	}

}
