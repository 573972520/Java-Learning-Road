package 反射案例;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import 反射.Chinese;

public class ReflectCase
{
	/**
	 * 获取obj指向的对象的propName属性的值
	 * @param obj
	 * @param propName  "age"
	 * @return
	 */
	public static Object getValue(Object obj, String propName) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Class clz = obj.getClass();
		//得到get的方法名，getAge
		String getMethodName = "get" + capitalize(propName);
		//拿到getAge方法
		Method getMethod = clz.getMethod(getMethodName);
		return getMethod.invoke(obj);
	}

	/**
	 * 给obj的propName属性赋值为value
	 * @param obj
	 * @param propName
	 * @param value
	 * @param valueClass
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void setValue(Object obj, String propName, Object value, Class valueClass)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException
	{
		Class clz = obj.getClass();
		//得到set的方法名，setAge
		String setMethodName = "set" + capitalize(propName);
		//拿到setAge方法
		Method getMethod = clz.getMethod(setMethodName, valueClass);
		getMethod.invoke(obj, value);
	}

	/**
	 * 将首字母大写，比如capitalize("age")会得到"Age"
	 * @param s
	 * @return
	 */
	public static String capitalize(String s)
	{
		char firstChar = s.charAt(0);
		return Character.toUpperCase(firstChar) + s.substring(1);
	}

	

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{
		Chinese c1 = new Chinese();
		c1.setAge(30);
		c1.setName("carl");

		setValue(c1, "age", 18, int.class);

		int age = (Integer) getValue(c1, "age");
		System.out.println(age);
		String name = (String) getValue(c1, "name");
		System.out.println(name);

	}
}
