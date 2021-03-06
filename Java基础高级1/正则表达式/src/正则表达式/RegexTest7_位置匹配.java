package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest7_位置匹配
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		String regex = "^abc$";//    ^ 匹配文本开始位置     $ 匹配文本结束位置
		String str = "abc";
		boolean match = Pattern.matches(regex, str);
		System.out.println(match);//ture

		String regex1 = "\\bhello\\b";
		String str1 = "xx hello,hello helloa";
		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(str1);
		while (matcher1.find())
		{
			String group1 = matcher1.group();
			System.out.println(group1); //hello hello(第三个helloa中的a不是单词的边界)
		}
	}

}
