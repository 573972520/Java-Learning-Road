package 反射;

public class ReflectTest2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Class clz = Person.class;//Class指向的对象:就是类
		try
		{
			Object obj = clz.newInstance();//调用clz指向的Class对象对应的类的无参构造函数，并且返回创建的对象
			//Object obj = new Person();等价于Object obj = clz.newInstance();
			System.out.println(obj); // 运行报错：没有找到无参的构造函数（因为在Person类中写了一个有参的构造函数）

			//其他Class的成员
			//isArray:是否为数组
			System.out.println(clz.isArray());
			//isPrimitive:判断是否为原始类型，
			System.out.println(int.class.isPrimitive()); //int是原始类型
			System.out.println(Integer.class.isPrimitive()); //Integer不是原始类型
			//isInterface:判断是否为接口
			Class clz2 = Comparable.class;
			System.out.println(clz2.isInterface());//true
			//getName()得到类名（包含包名）
			System.out.println(clz.getName());
			//getSuperclass() 得到父类的Class。
			Class clzParent = clz.getSuperclass();
			System.out.println(clzParent);//class java.lang.Object
			Class clzObjectParent = clzParent.getSuperclass();
			System.out.println(clzObjectParent);//null
			//isInstance(Object obj)：判断给定的对象obj是否是当前类类型的（可以是当前类的子类的对象）
			Person p1 = new Person();
			String s = "hello";
			Integer i = 5;
			Class clzPerson = Person.class;
			Class clzString = String.class;
			Class clzComparable = Comparable.class;

			System.out.println(clzPerson.isInstance(p1));//true---当前的p1是clzPerson类型的
			System.out.println(clzString.isInstance(p1));//false
			System.out.println(clzComparable.isInstance(i));//true---当前类的子类的对象

			//Person类型的对象能赋值给Object类型的变量
			//Integer类型的对象能赋值给Comparable接口
			//Integer类型的对象不能赋值给String类型的变量

			//isAssignableFrom(Class cls) 判断cls是否是当前类的类型或者当前类的子类类型。或者说：cls类型的对象能否赋值给当前类类型的变量
			Class clzObject = Object.class;
			System.out.println(clzObject.isAssignableFrom(clzString));//true
			System.out.println(clzComparable.isAssignableFrom(clzString));//true

			System.out.println(clzString.isAssignableFrom(clzObject));//false---错误原因如下面一行代码。相对于将Object类型的对象能赋值给String类型的变量
			//String s = new Object(); //这是错误的写法

		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
