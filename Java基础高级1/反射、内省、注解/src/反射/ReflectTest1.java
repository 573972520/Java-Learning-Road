package 反射;

public class ReflectTest1
{

	public static void main(String[] args)
	{
		/*// 获取类信息对象Class的三种方法
		//方法一
		Class clz1 = Person.class;//获得Person类对应的Class类的对象
		//定义一个Class类型的变量，指向Person类的描述对象
		
		//方法二
		Person p1 = new Person();
		Class clz2 = p1.getClass();//根据类的对象，获取类的描述对象
		
		//方法三
		//如果只知道类的包名和类名
		Class clz3;
		try
		{
			clz3 = Class.forName("反射.Person");
		} catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
		
		System.out.println(clz1);
		System.out.println(clz2);
		System.out.println(clz3);
		
		System.out.println(clz1 == clz2); //true
		System.out.println(clz3 == clz2); //true
		System.out.println(clz1 == clz3); //true
		//全部为true，说明拿到的是同一个Class类的对象
		
		Class clz4 = String.class;
		System.out.println(clz1 == clz4); //false,指向不同的对象
		
		
		//int、boolean、double、char基本类型（原始类型）也有class
		Class clz5 = int.class;//Integer是int的包装类
		Class clz6 = Integer.class;
		System.out.println(clz5 == clz6);//false 不是同一对象
		//基本数据类型的Class和包装类型的Class是两个不同的对象
		*/ }

}
