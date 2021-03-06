package 正则表达式;

import java.util.regex.Pattern;

public class RegexTest8_组
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String regex = "(red|blue|green) color";
		String str = "red color";
		boolean match = Pattern.matches(regex, str);
		System.out.println(match);//ture

		String regex1 = "(red|blue|green){3}";
		String str1 = "redredred";
		boolean match1 = Pattern.matches(regex1, str1);
		System.out.println(match1);//ture

		String regex2 = "(ab|bc)c\\1"; //相对于正则表达式的(ab|bc)c\1
		String str2 = "bccbc";
		boolean match2 = Pattern.matches(regex2, str2);
		System.out.println(match2);//ture

		String regex3 = "([ab])c\\1";//相对于正则表达式的[ab]c\1
		String str3 = "aca"; //或者bcb
		boolean match3 = Pattern.matches(regex3, str3);
		System.out.println(match3);//ture

		System.out.println(Pattern.matches("(a)(b)\\1\\2", "abab"));//true

	}

}
