package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest5
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String regex = "ab"; //要求str的子字符串substr="ab"
		String str = "xabxxabmmabx";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);

		//		boolean find = matcher.find();//查找str中是否有下一个匹配regex的子字符串(第一个ab)
		//		boolean find2 = matcher.find();//查找str中是否有下一个匹配regex的子字符串(第二个ab)
		//		System.out.println(find);//ture
		//		String group = matcher.group();
		//		System.out.println(group);//ab(第二个ab)

		while (matcher.find())
		{
			String group = matcher.group();
			System.out.println(group);
			//结果为
			//ab
			//ab
			//ab
		}


		//案例：打印出来一个字符串里面的所有的QQ邮箱
		String regex1 = "[1-9][0-9]{4,}@qq.com"; //QQ邮箱的正则表达式写法
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
