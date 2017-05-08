package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest6_非贪婪匹配和贪婪匹配
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String regex1 = "[1-9][0-9]{4,}?"; //非贪婪匹配(最后)，只会输出12345，如果是贪婪匹配则输出123451234561234567

		String str1 = "xx12345@qq.comabc123456@qq.commm1234567@qq.com";
		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(str1);
		while (matcher1.find())
		{
			String group1 = matcher1.group();
			System.out.println(group1);
		}
	}

}
