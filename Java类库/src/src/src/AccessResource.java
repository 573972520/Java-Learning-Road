package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class AccessResource
{

	
	
		//如何访问项目src下的资源文件？
		//实际执行时，就是如何访问bin目录下的资源文件
		//bin---java的类加载的根路径
		
		
		//如何获得资源的路径？
		//java提供了两种方式来获得类加载目录下的资源路径
	
		//第一种
		public static void main(String[] args) throws Exception
		{
			//使用class对象的getResource方法来获得资源的URL时，传递的参数要以/开头，这里的斜线就代表项目的bin目录，也就是类加载的根目录
			URL resourceURL = AccessResource.class.getResource("/a.txt");//需要指定资源的名称
			//得到资源的绝对路径
			String resourcePath = resourceURL.getFile();
			System.out.println(resourceURL);
			//如果在URL resourceURL = AccessResource.class.getResource("a.txt");中没有加上斜线，那么结果是null
			//如果在URL resourceURL = AccessResource.class.getResource("/a.txt");加上了斜线，那么结果是file:/Z:/JavaDay/Java%e7%b1%bb%e5%ba%93/src/bin/a.txt
			System.out.println(resourcePath);//结果是/Z:/JavaDay/Java%e7%b1%bb%e5%ba%93/src/bin/a.txt
			FileReader reader = new FileReader(new File(resourcePath));
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();
			System.out.println(line);
		}
		
		//第二种
		
		
		//资源的路径（可能是不固定的）  ---  所以需要动态的获取资源的绝对路径
		//File
		//Reader
		
	

}
