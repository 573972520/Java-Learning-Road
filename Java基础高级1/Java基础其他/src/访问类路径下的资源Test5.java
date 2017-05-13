import java.io.InputStream;
import java.net.URL;

public class 访问类路径下的资源Test5
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		URL url = 访问类路径下的资源Test5.class.getClassLoader().getResource("text1.txt");
		URL url1 = 访问类路径下的资源Test5.class.getClassLoader().getResource("load/text2.txt");
		System.out.println(url);
		//结果为：file:/Z:/JavaDay/Java%e5%9f%ba%e7%a1%80%e9%ab%98%e7%ba%a71/Java%e5%9f%ba%e7%a1%80%e5%85%b6%e4%bb%96/bin/text1.txt
		System.out.println(url1.getFile());
		//结果为：/Z:/JavaDay/Java%e5%9f%ba%e7%a1%80%e9%ab%98%e7%ba%a71/Java%e5%9f%ba%e7%a1%80%e5%85%b6%e4%bb%96/bin/load/text2.txt

		InputStream input = 访问类路径下的资源Test5.class.getClassLoader().getResourceAsStream("text1.txt");
		访问类路径下的资源Test5.class.getResource("/text1.txt"); //  其中"/"表示bin目录
	}

}
