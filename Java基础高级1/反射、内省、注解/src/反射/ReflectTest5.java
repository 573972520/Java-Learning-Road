package 反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest5
{

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException
	{
		// TODO Auto-generated method stub
		Class clz = Class.forName("反射.Chinese");
		Object person = clz.getConstructor().newInstance();//等价于clz.newInstance();获取无参构造函数
		Object person2 = clz.newInstance();

		System.out.println(person.getClass());
		Method setAgeMethod = clz.getMethod("setAge", int.class);
		setAgeMethod.invoke(person, 20);//相当于person.setAge(20)

		Method setNameMethod = clz.getMethod("setName", String.class);
		setNameMethod.invoke(person, "carl");//相当于person.setName(carl)

		Method setHelloMethod = clz.getMethod("sayHello");
		setHelloMethod.invoke(person);

	}

}
