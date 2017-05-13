
public class 类加载Test3
{

	public static int n = 6;
	static
	{
		System.out.println(n);
	}
	public static Object obj = new Object();
	static
	{
		System.out.println(obj);
	}

	public static void main(String[] args)
	{
		System.out.println("main");
	}

}
