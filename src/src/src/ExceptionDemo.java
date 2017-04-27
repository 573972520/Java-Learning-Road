package src;

public class ExceptionDemo {

	//为什么子类方法不能抛出父类方法没有声明的异常
	
	/*
	 * 所有的异常都是人为抛出的
	 * 可以把异常分为两种，检查异常和非检查异常
	 * 
	 * 1、如果一个方法可能会抛出检查异常，就需要在方法声明时明确的指出来，
	 *   那么调用这个方法的方法就需要明确指定该如何处理可能发生的异常，
	 *   可通过try-catch捕获此异常，也可以通过声明抛出相同的异常
	 *   
	 * 2、如果一个方法可能会抛出非检查异常，不需要在方法声明时指出会抛出此异常
	 *   这样调用者就认为此方法不会抛出异常，当然也就不需要处理异常
	 */
	public static void main(String[] args) {//throws Exception 
		// TODO Auto-generated method stub
		
		/*
		try {
			divide(10,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); //输出：java.lang.Exception: 被除数不能为0 
			System.out.println("输入错误:"+e.getMessage());//输出:输入错误:被除数不能为0
		}
		
		divide2(10,0);//输出:Exception in thread "main" java.lang.RuntimeException: 被除数不能为0
		*/
		
		//Parent p = new Parent();
		Parent p = new Child();
		printShow(p);
	}
	
	//检查异常
	public static int divide(int chushu,int beichushu) throws Exception
	{
		if(beichushu == 0)
		{
			throw new Exception("被除数不能为0");
		}
		return chushu/beichushu;
	}
	
	//非检查异常
	public static int divide2(int chushu,int beichushu)
	{
		if(beichushu == 0)
		{
			throw new RuntimeException("被除数不能为0"); //不需要在方法上抛出此异常
		}
		return chushu/beichushu;
	}
	
	//在当前编码时，我们并不能确定当前类的方法在以后子类覆盖时会抛出什么类型的异常，为了保证前面代码的安全，就禁止子类方法抛出父类方法没有声明的异常
	//如果父类方法声明抛出了一个检查异常，那么子类的方法可以声明抛出此异常的本身或此异常的子类，子类也可以不抛出任何异常
	//记忆方法：孩子不能够比他爹坏
	public static void printShow(Parent p)
	{
		p.show();
	}
}

class Parent
{
	public void show()
	{
		System.out.println("parent show...");
	}
}

class Child extends Parent
{
	@Override
	//会出错
	public void show()  //throws Exception
	{
		int i = 0;
		if(i > 0)
		{
			//throw new Exception("xxx"); 
		}
		System.out.println("child show...");
	}
}

