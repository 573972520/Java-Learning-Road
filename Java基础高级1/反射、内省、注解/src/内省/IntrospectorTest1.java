package 内省;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import 反射.Chinese;

public class IntrospectorTest1
{

	public static void main(String[] args) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		// TODO Auto-generated method stub
		Chinese c1 = new Chinese();
		c1.setAge(34);
		c1.setName("carl");
		c1.setPhoneNum("1987458585");

		BeanInfo beanInfo = Introspector.getBeanInfo(Chinese.class);

		//获取所有属性（包含只读、只写）
		PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor prop : props)
		{
			System.out.println("属性名" + prop.getName() + ",属性类型:" + prop.getPropertyType());
			Method methodRead = prop.getReadMethod(); //读方法
			Method methodWrite = prop.getWriteMethod();//写方法
			if (methodRead != null)
			{
				System.out.println("读方法" + methodRead);
				Object propValue = methodRead.invoke(c1);
				System.out.println(prop.getName() + "=" + propValue);
			}
			if (methodWrite != null)
			{
				System.out.println("写方法" + methodWrite);
			}
			System.out.println("--------------------------------");
		}
	}

}
