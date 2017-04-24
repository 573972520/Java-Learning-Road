package wrapper;

public class WrapperTest2 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		/*
		Integer i1 = new Integer(4); //装箱
		test(i1);
		
		//int i = null;//通过包装类可以使之等于null
		Integer i2 = null;
		*/
		
		Integer i = 3;  //主动装箱
		//对于上述代码，在反编译器中显示的是 Integer i = Integer.valueOf(3);
		//对于valueOf方法会返回Integer i = new Integer(3);
		int i1 = i;//自动拆箱
		System.out.println(i1);
		test(3);
		
		Integer i2 = null;
		//int i4 = i2; //相当于i2.intValue(); 即执行i2指向的对象的intValue方法，但是i2没有指向任何对象，所以错误
		//System.out.println(i4);//报错NullPointerException
		//所以为了不报错可以加一个判断
		if(i2 != null)
		{
			int i4 = i2; 
			System.out.println(i4);
		}
		
	}
	
	public static void test(Object obj)
	{
		if(obj instanceof Integer)
		{
			Integer i = (Integer)obj;
			System.out.println(i.intValue()); //相对于WrapperTest1中的getValue方法（拆箱）
		}
	}
}
