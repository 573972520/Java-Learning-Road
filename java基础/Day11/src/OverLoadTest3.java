
public class OverLoadTest3 implements Runnable
{

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
	}
	
	static void f1(int i)
	{
		System.out.println("I'm f_1");
	}
	/*
	//参数名字不一样不能构成重载
	static void f1(int j)
	{
		System.out.println("I'm f_2");
	}
	//返回值类型不一样不能构成重载
	static boolean f1 (int i)
	{
		System.out.println("I'm f_3");
		return true;
	}
	*/
	static void f1(double d)
	{
		System.out.println("I'm f_2");
	}
	static void f1(long l)
	{
		System.out.println("I'm f_3");
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		f1(3);      //I'm f_1
		f1(3.14);   //I'm f_2
		double d = 3.14;
		f1((int)d); //I'm f_1
		int i = 5;
		f1((double)i);//I'm f_2
		double d1 = i;
		f1(d1);      //I'm f_2
	}

}
