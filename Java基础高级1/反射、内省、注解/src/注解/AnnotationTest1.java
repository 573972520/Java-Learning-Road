package 注解;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class AnnotationTest1
{

	public static void print(Object obj)
	{
		try
		{
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			//获取所有属性（包含只读、只写）
			PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor prop : props)
			{
				Method methodRead = prop.getReadMethod();
				MyNotPrint notPrint = methodRead.getAnnotation(MyNotPrint.class);
				if (notPrint != null)//如果get方法上标注了@MyNotPrint,则不打印这个属性
				{
					continue;
				}
				Object value = methodRead.invoke(obj);
				String propName = prop.getName();
				MyDisplayName myDisplayName = methodRead.getAnnotation(MyDisplayName.class);
				if (myDisplayName != null)
				{
					propName = myDisplayName.displayName();
				}
				System.out.println(prop.getName() + "=" + value);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args)
	{
		Person p1 = new Person();
		p1.setAge(45);
		p1.setName("tom");
		p1.setPhoneNum("23489723234789");
		print(p1);
	}

}
