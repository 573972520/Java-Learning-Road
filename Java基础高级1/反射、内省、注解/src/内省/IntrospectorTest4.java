package 内省;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;


public class IntrospectorTest4
{

	public static void main(String[] args)
	{
		try
		{
			Dog d = (Dog) readFormFile("d:\\dog.txt");
			System.out.println(d);
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static Object readFormFile(String file) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader buffReader = null;
		try
		{

			fis = new FileInputStream(file);
			reader = new InputStreamReader(fis);
			buffReader = new BufferedReader(reader);
			String className = buffReader.readLine();//读取第一行的类名
			Class clz = Class.forName(className);
			Object obj = clz.newInstance();//创建类的对象

			BeanInfo beanInfo = Introspector.getBeanInfo(clz);
			PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
			String line;
			while ((line = buffReader.readLine()) != null)
			{
				String[] strs = line.split("=");
				String propName = strs[0];//属性名
				String propValue = strs[1];//属性值
				PropertyDescriptor prop = findPropertyDescriptor(props, propName);//查找propName代表的属性的PropertyDescriptor
				if (prop != null)
				{
					//因为属性的类型可能不是String类型的，但是从文件中读取的属性值是String类型，所以需要做类型转换
					//prop.getPropertyType()是属性的类型
					Object objVlaue = convert(propValue, prop.getPropertyType());

					//setId("3")
					//prop.getWriteMethod().invoke(obj, propValue);//调用set***方法给属性赋值
					prop.getWriteMethod().invoke(obj, objVlaue);
				}

			}
			return obj;
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
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
		} catch (InstantiationException e)
		{
			throw new RuntimeException(e);
		} finally
		{
			closeQueitly(buffReader);
			closeQueitly(reader);
			closeQueitly(fis);
		}
		
		
	}
	
	/**
	 * 把字符串类型的数据s转换成targetClass类型的对象 convert("3") --> 3      convert("3.24") --> 3.24
	 * @param s
	 * @param targetClass
	 * @return
	 */
	private static Object convert(String s, Class targetClass)
	{
		if (targetClass == int.class || targetClass == Integer.class)
		{
			return Integer.parseInt(s);
		} else if (targetClass == double.class || targetClass == Double.class)
		{
			return Double.parseDouble(s);
		} else if (targetClass == String.class)
		{
			return s;
		} else
		{
			throw new IllegalArgumentException("这个类型我不支持" + targetClass);
		}
	}

	/**
	 * 从props中找到名字等于PropertyDescriptor，如果没有则返回null
	 * @param props
	 * @param propName
	 * @return
	 */
	private static PropertyDescriptor findPropertyDescriptor(PropertyDescriptor[] props, String propName)
	{
		for (PropertyDescriptor prop : props)
		{
			if (prop.getName().equals(propName))
			{
				return prop;
			}
		}
		return null;
	}

	private static void closeQueitly(Closeable c)
	{
		if (c != null)
		{
			try
			{
				c.close();
			} catch (IOException e)
			{

			}
		}
	}

}
