package 正则表达式;

import java.util.regex.Pattern;

public class RegexTest1_普通字符和元字符
{

	public static void main(String[] args)
	{

		/*String regex = "abcd";//正则表达式要求字符串为abc
		String str = "abcd";*/

		/*String regex = "."; //要求字符串srt的值为任意一个字符
		String str = "把";*/



		String regex = "\\.";//表示\. -->  因为"\"在java中代表转义字符 所以需要两个反斜线才能代表一个斜线"\"
		String str = ".";
		boolean match = Pattern.matches(regex, str);
		System.out.println(match);//ture

		String regex1 = ".";
		String str1 = "\f";
		boolean match1 = Pattern.matches(regex1, str1);
		System.out.println(match1);//true

		/*
		String regex1 = "\\n"; //表示java中的\n这两个字符
		String str1 = "\n";	//所以也能匹配
		boolean match1 = Pattern.matches(regex1, str1);
		System.out.println(match1);//true
		
		String regex2 = "\n";//因为\n表示java中的换行字符
		String str2 = "\n"; //所以这里直接拿换行字符进行了匹配
		boolean match2 = Pattern.matches(regex2, str2);
		System.out.println(match2);//true
		*/

		/*
		String regex = ".";
		String str = "\t";
		boolean match = Pattern.matches(regex, str);
		System.out.println(match); //true 
		
		String regex1 = ".";
		String str1 = "\n";
		boolean match1 = Pattern.matches(regex1, str1);
		System.out.println(match1); //false
		
		String regex2 = ".";
		String str2 = "\r";
		boolean match2 = Pattern.matches(regex2, str2);
		System.out.println(match2); //false
		 */
		System.out.println("123" + "\r\n" + "23");
	}

}
