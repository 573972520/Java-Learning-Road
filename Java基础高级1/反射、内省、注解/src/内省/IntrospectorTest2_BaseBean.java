package 内省;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class IntrospectorTest2_BaseBean
{
	@Override
	public String toString()
	{
		Class clz = this.getClass(); //this指向的是Dog类型的对象
		//clz指向的是Dog类的Class，不是BaseBean
		BeanInfo beanInfo;
		try
		{
			beanInfo = Introspector.getBeanInfo(clz);
			PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
			StringBuilder sb = new StringBuilder();
			for (PropertyDescriptor prop : props)
			{
				//只读:只有get，没有set
				if (!prop.getName().equals("class") && prop.getReadMethod() != null)
				{
					Object value = prop.getReadMethod().invoke(this);
					sb.append(prop.getName() + "=" + value + "|");
				}

			}
			return sb.toString();
		} catch (IntrospectionException e)
		{
			throw new RuntimeException(e);
		} catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e)
		{
			throw new RuntimeException(e);
		} catch (InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}


	}
}
