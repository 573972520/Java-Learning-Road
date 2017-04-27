package properties配置文件;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import file文件处理.IOUtils;

public class PropertiesTest1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		InputStream inStream = null;
		try
		{
			//从eclipse中导入
			inStream = PropertiesTest1.class.getClassLoader().getResourceAsStream("p.properties");
			//inStream = new FileInputStream("Z:\\JavaDay\\Java类库\\java常用类库\\src\\properties配置文件\\p.properties");
			//从文件夹导入
			System.out.println(inStream.getClass()); //返回的是BufferedInputStream类型
			Properties prop = new Properties();
			prop.load(inStream);
			String serverip = prop.getProperty("ServerIP");
			String username = prop.getProperty("UserName");
			String password = prop.getProperty("Password", "123");
			System.out.println(serverip);
			System.out.println(username);
			System.out.println(password);
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("文件未找到");
		} 
		catch (IOException e)
		{
			System.out.println("读取错误");
		}
		finally
		{
			IOUtils.closeQuietly(inStream);
		}
	}

}





