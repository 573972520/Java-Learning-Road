package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
public class ReflectTest3
{

	public static void main(String[] args) throws SecurityException, NoSuchMethodException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException
	{
		// TODO Auto-generated method stub

		Class clzChinese = Chinese.class;
		Constructor c1 =clzChinese.getConstructor(int.class, String.class);
		System.out.println(c1);
		Constructor c2 = clzChinese.getConstructor(String.class);
		System.out.println(c2);

		Object obj2 = c1.newInstance(999, "fuck");
		System.out.println(obj2);//name=fuck,age=999,phoneNum=null
		Object obj3 = c2.newInstance("tom");//相对于new Person("ton");
		System.out.println(obj3);//name=tom,age=50,phoneNum=null

		for (Constructor c : clzChinese.getConstructors())
		{
			System.out.println(c);
			/*	结果：
				public 反射.Chinese(java.lang.String)
				public 反射.Chinese(int,java.lang.String)
				public 反射.Chinese()*/
		}

	}

}
