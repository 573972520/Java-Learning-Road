package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest9_标记_flag
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String regex1 = "\\bhello\\b";
		String str1 = "xx Hello,heLLo helloa";
		Pattern pattern1 = Pattern.compile(regex1, Pattern.CASE_INSENSITIVE);//忽略大小写
		Matcher matcher1 = pattern1.matcher(str1);
		while (matcher1.find())
		{
			String group1 = matcher1.group();
			System.out.println(group1);
		}
	}

}
