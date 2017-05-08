package 正则表达式;

import java.util.regex.Pattern;

public class RegexTest10
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(Pattern.matches("^[0-9]*$", "abab"));//校验数字
		System.out.println(Pattern.matches("^[0-9]+([,][0-9]+){0,1}", "abab"));//校验整数或者小数
		System.out.println(Pattern.matches("[1-9][0-9]{4,}", "abab"));//校验qq号
		System.out.println(Pattern.matches("^1[34578]\\d{9}$", "abab"));//校验手机号
		System.out.println(Pattern.matches("(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|x|X)$)", "abab"));//校验身份证
		System.out.println(Pattern.matches(
				"^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$",
				"abab"));//校验日期（格式：yyyy-mm-dd，已考虑平闰年）
		System.out.println(Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", "abab"));//校验email地址
		System.out.println(Pattern.matches("^[a-zA-z]+://[^\\s]*$", "abab"));//校验URL
		
	}

}
