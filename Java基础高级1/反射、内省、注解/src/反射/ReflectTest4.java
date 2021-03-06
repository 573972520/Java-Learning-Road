package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectTest4
{

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException
	{
		// TODO Auto-generated method stub

		Class clz = Chinese.class;
		Field fa = clz.getField("Count");//获得的是public字段
		System.out.println(fa);

		//Field fa1 = clz.getField("aa");//NoSuchFieldException没有这么一个字段（因为aa是private）
		//System.out.println(fa1);

		/*
		System.out.println("变量的名字" + fa.getName());
		System.out.println("变量的类型" + fa.getGenericType());
		//getFields:获得所有的public字段,包括父类的
		for (Field f : clz.getFields())
		{
			System.out.println("变量名" + f.getName() + ",类型为" + f.getGenericType());
		}
		//getDeclaredFields:获得自己声明的所有字段,包括private的
		for (Field f : clz.getDeclaredFields())
		{
			System.out.println("变量名" + f.getName() + ",类型为" + f.getGenericType());
		}
		*/

		/*
		//getMethods:获得所有的public方法,包括父类的
		for (Method m : clz.getMethods())
		{
			System.out.println(
					"方法名" + m.getName() + ",类型为" + m.getReturnType() + "，参数类型" + Arrays.toString(m.getParameters()));
		}
		*/
		//getDeclaredMethods://获得自己声明的所有方法,包括private的
		for (Method m : clz.getDeclaredMethods())
		{
			System.out.println(
					"方法名" + m.getName() + ",类型为" + m.getReturnType() + "，参数类型" + Arrays.toString(m.getParameters())
							+ ",修饰符" + Modifier.isPublic(m.getModifiers()));
		}

		Method m1 = clz.getMethod("hello", String.class);
		System.out.println(m1);

		Constructor c1 = clz.getConstructor(int.class, String.class);

	}

}
