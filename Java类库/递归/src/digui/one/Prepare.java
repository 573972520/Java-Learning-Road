package digui.one;

public class Prepare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		a();
		c();
	}
	
	//递归准备知识点
	
	//1  代码执行顺序
	//当main方法调用a方法时，程序进入到a方法，执行a方法的代码，
	//在a方法中调用b方法时候，程序会进入到b方法中，执行b方法的代码，
	//当b方法执行完成的时候，那整个b方法就执行完成，b方法返回，程序就回到了a方法，
	public static void a()
	{
		System.out.println("a");
		b();
		System.out.println("c");
	}
	public static void b()
	{
		System.out.println("b");
	}
	
	//2  方法执行时内存做了什么
	//每个方法的每次执行，java虚拟机都会为这个方法在栈内存中分配一块单独不共享的内存空间
	//当一个方法执行完成的时候，虚拟机将会回收给这个方法这次执行分配的内存空间
	public static void c()
	{
		int i = 1;
		d();
		System.out.println(i);
	}
	public static void d()
	{
		int i = 5;
	}
}
