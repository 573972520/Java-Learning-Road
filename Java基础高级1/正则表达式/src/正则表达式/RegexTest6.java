package 正则表达式;

import java.util.Arrays;

public class RegexTest6
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String str = "34ty455465jk34";
		String newStr = str.replaceAll("[0-9]", "*");
		String str1 = str.replace("5", "*");
		System.out.println(newStr);
		System.out.println(str1);
		String[] parts = str.split("[0-9]+");//任意的连续的数字去切割字符串
		System.out.println(Arrays.toString(parts));
		
		System.out.println(str.matches("5jk34")); //false
		
	}

}
