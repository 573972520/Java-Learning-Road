package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;

public class AccessResource
{
	
		//如何访问项目src下的资源文件？
		//实际执行时，就是如何访问bin目录下的资源文件
		//bin---java的类加载的根路径
		
		
		//如何获得资源的路径？
		//java提供了两种方式来获得类加载目录下的资源路径
	
		//第一种
		/*
		public static void main(String[] args) throws Exception
		{
			//使用class对象的getResource方法来获得资源的URL时，传递的参数要以/开头，这里的斜线就代表项目的bin目录，也就是类加载的根目录
			
			//如果资源在包下面，指定资源名称的时候，需要指定包所对应的目录
			//URL resourceURL = AccessResource.class.getResource("/a.txt");//需要指定资源的名称（资源不与AccessResource.java文件同级）
			URL resourceURL = AccessResource.class.getResource("/src/a.txt");//需要指定资源的名称（资源与AccessResource.java文件同级）
			//得到资源的绝对路径
			String resourcePath = resourceURL.getFile();
			System.out.println(resourceURL);
			//如果在URL resourceURL = AccessResource.class.getResource("a.txt");中没有加上斜线，那么结果是null
			//如果在URL resourceURL = AccessResource.class.getResource("/a.txt");加上了斜线，那么结果是file:/Z:/JavaDay/src/bin/src/a.txt
			System.out.println(resourcePath);//结果是/Z:/JavaDay/src/bin/src/a.txt
			FileReader reader = new FileReader(new File(resourcePath));
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();
			System.out.println(line);
		}
		*/
		
		//资源的路径（可能是不固定的）  ---  所以需要动态的获取资源的绝对路径
		//File
		//Reader
		
		
		//第二种
		public static void main(String[] args) 
		{
			//类加载器获取资源的URL时，资源名称不能以斜线(/)开头
			
			/*
			//（1）资源不与AccessResource.java同级
			URL resourceURL = AccessResource.class.getClassLoader().getResource("a.txt");
			//System.out.println(resourceURL);//当URL resourceURL = AccessResource.class.getClassLoader().getResource("/a.txt");加上斜线的时候，结果为null
			System.out.println(resourceURL);//当URL resourceURL = AccessResource.class.getClassLoader().getResource("a.txt");不加上斜线的时候，结果为file:/Z:/JavaDay/src/bin/a.txt
			*/
			
			//（2）资源与AccessResource.java同级
			URL resourceURL = AccessResource.class.getClassLoader().getResource("src/a.txt");
			//System.out.println(resourceURL);//当URL resourceURL = AccessResource.class.getClassLoader().getResource("/src/a.txt");加上斜线的时候，结果为null
			System.out.println(resourceURL);//当URL resourceURL = AccessResource.class.getClassLoader().getResource("src/a.txt");不加上斜线的时候，结果为file:/Z:/JavaDay/src/bin/a.txt
			
			//获取输入流来访问资源
			InputStream in = AccessResource.class.getClassLoader().getResourceAsStream("src/s.txt");
		}

}

