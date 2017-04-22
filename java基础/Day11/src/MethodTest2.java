
public class MethodTest2
{
	static int getNine()
	{
		return 9;
	}

	static String str(String s)
	{
		return s;
	}
	static String strint(String s,int i){
		return s+i;
	}
	static int add(int i)
	{
		i++; // 方法内部修改参数的值，不会影响到调用者，因为这里传过来的是一份“拷贝”的值
		return i;
	}
	//return之后方法就结束了，后续的代码就不会执行了
	static void hello(){   //void表示方法“没有返回值”
		System.out.println("hello各位");
	}
	static void sayHello(String name){
		System.out.println("大家好,我是"+name);
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int i = getNine();
		System.out.println(i);// 9
		int j = add(i);
		System.out.println(j);// 10
		System.out.println(i);// 9
		// 对于方法来讲，调用的时候，对于普通数据类型int、boolean等是拷贝一份传递给方法的，所以上面的i不会增加
		int a = 5;
		String s = "h";
		System.out.println(str(s));
		System.out.println(strint(s, a));
		hello();
		String s1 = "张三";
		sayHello(s1);
		sayHello("Carl");
 	}

}
