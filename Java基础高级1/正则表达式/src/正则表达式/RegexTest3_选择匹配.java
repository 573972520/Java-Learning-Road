package 正则表达式;

import java.util.regex.Pattern;

public class RegexTest3_选择匹配
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(Pattern.matches("a|b|c|", "")); //true  匹配a或者b或者c或者空字符串（因为c后面还有一个竖线）
		System.out.println(Pattern.matches("helloa|b|c", "b")); //true  匹配helloa或者b或者c  （hellob和helloc不会匹配）
		System.out.println(Pattern.matches("red|green|blue", "green"));
	}

}
