
public class JVMTest2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Integer n1 = 127;//编译器会优化成n1.valueOf(127);
		Integer n2 = 127;
		Integer n3 = 128;
		System.out.println(n1 == n2);//true
		System.out.println(n1 == n3);//false

		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc"); //创建了一个新的对象
		System.out.println(s1 == s2);//true
		System.out.println(s1 == s3);//false
	}

}
